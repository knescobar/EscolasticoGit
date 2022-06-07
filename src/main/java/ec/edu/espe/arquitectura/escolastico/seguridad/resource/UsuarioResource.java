package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioResource {
    
    private UsuarioService usuarioSrvice;

    public UsuarioResource(UsuarioService usuarioSrvice) {
        this.usuarioSrvice = usuarioSrvice;
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(Usuario usuario) {
        usuario = this.usuarioSrvice.crear(usuario);
        return ResponseEntity.ok(usuario);
    }
}
