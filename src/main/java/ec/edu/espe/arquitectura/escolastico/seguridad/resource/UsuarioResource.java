package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.dto.CrearUsuarioDto;
import ec.edu.espe.arquitectura.escolastico.seguridad.dto.LoginDto;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioResource {

    private final UsuarioService usuarioService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuariosActivos() {
        return ResponseEntity.ok(this.usuarioService.buscarPorEstadoActivo());
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody CrearUsuarioDto usuarioDto) {
        String claveUsuario = this.usuarioService.crear(usuarioDto);
        return ResponseEntity.ok("Usuario "+usuarioDto.getCodUsuario()+" creado correctamente con la clave: "+claveUsuario );
    }

    // TODO: Hacer que esto retorne un MessageResponse:w
    @PutMapping
    public ResponseEntity<CrearUsuarioDto> modificar(@RequestBody CrearUsuarioDto usuarioDto) {
        this.usuarioService.modificar(usuarioDto);
        return ResponseEntity.ok(usuarioDto);
    }

    @PutMapping(path = "/login")
    public ResponseEntity<String> inicoSesion(@RequestBody LoginDto loginDto) {
        this.usuarioService.inicioSesion(loginDto.getCodigoOMail(), loginDto.getPassword());
        //Usuario usuario = this.usuarioService.buscarPorCodigoOMail(loginDto.getEmail());
        return ResponseEntity.ok("Logged in");
    }
}
