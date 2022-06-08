package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import ec.edu.espe.arquitectura.escolastico.seguridad.CambioClaveException;
import ec.edu.espe.arquitectura.escolastico.seguridad.EstadoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioPerfilRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioPerfilRepository usuarioPerfilRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioPerfilRepository usuarioPerfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioPerfilRepository = usuarioPerfilRepository;
    }

    public Usuario buscarPorCodigo(String codigo) {
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findById(codigo);
        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get();
        } else {
            return null;
        }
    }

    public Usuario buscarPorMail(String mail) {
        return this.usuarioRepository.findByMail(mail);
    }

    public Usuario buscarPorCodigoOMail(String valor) {
        Usuario usuario = this.buscarPorCodigo(valor);
        if (usuario == null) {
            usuario = this.buscarPorMail(valor);
        }
        return usuario;
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


    public void inicioSesion(String codigoOMail, String clave) throws CambioClaveException {
        Usuario usuario = this.buscarPorCodigoOMail(codigoOMail);
        if (usuario == null) {
            throw new CambioClaveException("No existe el usuario para el codigo o correo provisto");
        }
        if(usuario.getEstado().equals(EstadoPersonaEnum.ACTIVO.getValor())){

            if(usuario.getNroIntentosFallidos()>3){
                usuario.setEstado(EstadoPersonaEnum.BLOQUEADO.getValor());
                usuario.setNroIntentosFallidos(0);
            }else{
                clave= DigestUtils.sha256Hex(clave);
                if (!usuario.getClave().equals(clave)) {
                    usuario.setNroIntentosFallidos(usuario.getNroIntentosFallidos()+1);
                }else{
                    usuario.setFechaUltimaSesion(new Date());
                }
                
                this.usuarioRepository.save(usuario);
            }
           
        }else{
            throw new CambioClaveException("Usuario inactivo");
        }
       
    }
 }
