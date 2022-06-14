package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import ec.edu.espe.arquitectura.escolastico.seguridad.dao.RegistroSesionRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioPerfilRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.enums.EstadoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.enums.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.CambioClaveException;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.InicioSesionException;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.RegistroSesion;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.escolastico.shared.exception.CrearException;
import ec.edu.espe.arquitectura.escolastico.shared.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private static final int MAX_NUM_INTENTOS_FALLIDOS = 3;

    private final UsuarioRepository usuarioRepository;
    private final UsuarioPerfilRepository usuarioPerfilRepository;
    private final RegistroSesionRepository registroRepository;
    private String error;
    private String resultado;

    public Usuario buscarPorCodigo(String codigo) {
        return this.usuarioRepository.findById(codigo)
                .orElseThrow(() -> new NoEncontradoException("No existe un usuario con el código indicado."));
    }

    public Usuario buscarPorMail(String mail) {
        return this.usuarioRepository.findByMail(mail)
                .orElseThrow(() -> new NoEncontradoException("No existe un usuario con el correo indicado."));
    }

    private Usuario buscarPorCodigoOMail(String valor) {
        return this.usuarioRepository.findByMail(valor)
                .orElse(this.usuarioRepository.findById(valor)
                        .orElseThrow(() -> new InicioSesionException(
                                "No existe el usuario para el codigo o correo provisto")));
    }

    public List<Usuario> buscarPorNombre(String nombrePattern) {
        return this.usuarioRepository.findByNombreLikeOrderByNombre("%" + nombrePattern + "%");
    }

    public List<Usuario> buscarPorNombreYEstado(String nombrePattern, EstadoPersonaEnum estado) {
        return this.usuarioRepository.findByNombreLikeAndEstadoOrderByNombre(nombrePattern, estado.getValor());
    }

    public List<Usuario> buscarPorEstado(EstadoPersonaEnum estado) {
        return this.usuarioRepository.findByEstado(estado.getValor());
    }

    public List<Usuario> buscarPorEstadoActivo() {
        return this.usuarioRepository.findByEstado(EstadoPersonaEnum.ACTIVO.getValor());
    }

    public Usuario crear(Usuario usuario) {
        if (usuario.getPerfiles() == null ||
                usuario.getPerfiles().isEmpty()) {
            throw new CrearException(
                    "Error al crear el usuario, los perfiles son requeridas");
        }
        String clave = RandomStringUtils.randomAlphabetic(8);
        usuario.setClave(DigestUtils.sha256Hex(clave));
        usuario.setFechaCreacion(new Date());
        this.usuarioRepository.save(usuario);
        this.usuarioPerfilRepository.saveAll(usuario.getPerfiles());
        return usuario;
    }

    public void cambiarClave(String codigoOMail, String claveAntigua, String claveNueva) throws CambioClaveException {
        Usuario usuario = this.buscarPorCodigoOMail(codigoOMail);
        if (usuario == null) {
            throw new CambioClaveException("No existe el usuario para el codigo o correo provisto");
        }
        claveAntigua = DigestUtils.sha256Hex(claveAntigua);
        if (!usuario.getClave().equals(claveAntigua)) {
            throw new CambioClaveException("La clave antigua no coincide");
        }
        usuario.setClave(DigestUtils.sha256Hex(claveNueva));
        usuario.setFechaCambioClave(new Date());
        this.usuarioRepository.save(usuario);
    }

    public void modificar(Usuario usuario) {
        Usuario usuarioDB = this.buscarPorCodigo(usuario.getCodUsuario());
        usuarioDB.setNombre(usuario.getNombre());
        usuarioDB.setMail(usuario.getMail());
        usuarioDB.setTelefono(usuario.getTelefono());
        usuarioDB.setEstado(usuario.getEstado());
        usuarioDB.setAudFecha(new Date());
        usuarioDB.setPerfiles(usuario.getPerfiles());
        this.usuarioRepository.save(usuarioDB);
    }

    public void registroSesion(String codigo, String resultado, String error) {

        RegistroSesion registroUsuario = new RegistroSesion();
        registroUsuario.setCodUsuario(codigo);
        registroUsuario.setIpConexion("localhost");
        registroUsuario.setFechaConexion(new Date());
        registroUsuario.setError(error);
        registroUsuario.setResultado(resultado);

        this.registroRepository.save(registroUsuario);
    }

    public void inicioSesion(String codigoOMail, String clave) {
        Usuario usuario = this.buscarPorCodigoOMail(codigoOMail);

        boolean esUsuarioInactivo = usuario.getEstado().equals(EstadoPersonaEnum.INACTIVO.getValor());
        if (esUsuarioInactivo) {
            throw new InicioSesionException("El usuario se encuentra inactivo.");
        }

        if (usuario.getNroIntentosFallidos() == MAX_NUM_INTENTOS_FALLIDOS) {
            usuario.setEstado(EstadoPersonaEnum.BLOQUEADO.getValor());
            usuario.setNroIntentosFallidos(0);

            this.setError("Error");
            this.setResultado(EstadosEnum.FALLIDO.getValor());

            throw new InicioSesionException("Demasiados intentos fallidos, usuario bloqueado");
        }

        if (!usuario.getClave().equals(clave)) {
            usuario.setNroIntentosFallidos(usuario.getNroIntentosFallidos() + 1);
            this.setError("Clave");
            this.setResultado(EstadosEnum.FALLIDO.getValor());
            throw new CrearException("Clave incorrecta");
        }

        usuario.setFechaUltimaSesion(new Date());
        this.setResultado(EstadosEnum.SATISFACTORIO.getValor());
        this.setError("");

        this.usuarioRepository.save(usuario);
        this.registroSesion(usuario.getCodUsuario(), resultado, error);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
