package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.PerfilService;

@RestController
@RequestMapping(path = "/perfil")
public class PerfilResource {
    private PerfilService perfilService;

    public PerfilResource(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping
    public ResponseEntity<List<Perfil>> getPerfilActivos() {
        return ResponseEntity.ok(this.perfilService.listarModulosActivos());
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Perfil perfil) {
        this.perfilService.crear(perfil);
        return ResponseEntity.ok("Perfil creado");
    }

    @PutMapping
    public ResponseEntity<Perfil> modificar(@RequestBody Perfil perfil) {
        try {
            this.perfilService.modificar(perfil);
            perfil = this.perfilService.obtenerPorCodigo(perfil.getCodPerfil());
            return ResponseEntity.ok(perfil);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
