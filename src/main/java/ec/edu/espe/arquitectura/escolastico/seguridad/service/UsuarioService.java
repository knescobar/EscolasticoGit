package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import ec.edu.espe.arquitectura.escolastico.seguridad.dao.RegistroSesionRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioPerfilRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dto.UsuarioDto;
import ec.edu.espe.arquitectura.escolastico.seguridad.enums.EstadoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.enums.EstadosEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.CambioClaveException;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.InicioSesionException;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.*;
import ec.edu.espe.arquitectura.escolastico.shared.exception.CrearException;
import ec.edu.espe.arquitectura.escolastico.shared.exception.NoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public String crear(UsuarioDto dto) {
        existeUsuarioPorCodigoOMail(dto.getCodUsuario(), dto.getMail());
        Usuario nuevoUsuario = new Usuario();

        List<UsuarioPerfil> usuarioPerfiles = obtenerPerfilesDeUsuario(dto);
        String clave = RandomStringUtils.randomAlphabetic(8);
        nuevoUsuario.setCodUsuario(dto.getCodUsuario());
        nuevoUsuario.setMail(dto.getMail());
        nuevoUsuario.setNombre(dto.getNombre());
        nuevoUsuario.setOrigen(dto.getOrigen());
        nuevoUsuario.setTelefono(dto.getTelefono());
        nuevoUsuario.setClave(DigestUtils.sha256Hex(clave));
        nuevoUsuario.setNroIntentosFallidos(0);
        nuevoUsuario.setFechaCreacion(new Date());
        nuevoUsuario.setEstado("ACT");
        nuevoUsuario.setAudUsuario("");
        nuevoUsuario.setAudFecha(new Date());
        nuevoUsuario.setAudIp("localhost");
        this.usuarioRepository.save(nuevoUsuario);
        this.usuarioPerfilRepository.saveAll(usuarioPerfiles);
        return clave;
    }
    private void existeUsuarioPorCodigoOMail(String codUsuario, String mail) throws CrearException {
        Optional<Usuario> usuarioCodigoOpt = usuarioRepository.findById(codUsuario);
        Optional<Usuario> usuarioMailOpt = usuarioRepository.findByMail(mail);
        if(usuarioCodigoOpt.isPresent()|| usuarioMailOpt.isPresent() ){
            throw new CrearException("El código de usuario o mail indicado ya existe");
        }
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

    public void modificar(UsuarioDto dto) {
        Usuario usuarioDB = this.buscarPorCodigo(dto.getCodUsuario());
        usuarioDB.setNombre(dto.getNombre());
        usuarioDB.setMail(dto.getMail());
        usuarioDB.setTelefono(dto.getTelefono());
        usuarioDB.setAudFecha(new Date());
        List<UsuarioPerfil> perfilesAntiguosUsuario = this.usuarioPerfilRepository.findByPkCodUsuario(dto.getCodUsuario());
        List<UsuarioPerfil> perfilesNuevosUsuario= obtenerPerfilesDeUsuario(dto);
        this.usuarioPerfilRepository.deleteAll(perfilesAntiguosUsuario);
        usuarioDB.setPerfiles(perfilesNuevosUsuario);
        usuarioDB.setAudFecha(new Date());
        this.usuarioRepository.save(usuarioDB);
    }
    private List<UsuarioPerfil> obtenerPerfilesDeUsuario(UsuarioDto dto) {
        return dto.getPerfiles().stream()
                .map((perfiles) -> new UsuarioPerfilPK(dto.getCodUsuario(), perfiles))
                .map((pk) -> {
                    UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
                    usuarioPerfil.setPk(pk);
                    usuarioPerfil.setAudFecha(new Date());
                    usuarioPerfil.setAudUsuario("");
                    usuarioPerfil.setAudIp("localhost");
                    return usuarioPerfil;
                })
                .collect(Collectors.toList());
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
            this.registroSesion(usuario.getCodUsuario(), resultado, error);
            this.usuarioRepository.save(usuario);
            throw new InicioSesionException("Demasiados intentos fallidos, usuario bloqueado");
        }

        if (!usuario.getClave().equals(DigestUtils.sha256Hex(clave))) {
            usuario.setNroIntentosFallidos(usuario.getNroIntentosFallidos() + 1);
            this.setError("Clave");
            this.setResultado(EstadosEnum.FALLIDO.getValor());
            this.registroSesion(usuario.getCodUsuario(), resultado, error);
            this.usuarioRepository.save(usuario);
            throw new CrearException("Clave incorrecta");
        }

        usuario.setFechaUltimaSesion(new Date());
        this.setResultado(EstadosEnum.SATISFACTORIO.getValor());
        this.setError(null);
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
