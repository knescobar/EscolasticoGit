package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.ModuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/modulo")
public class ModuloResource {
    
    private ModuloService service;

    public ModuloResource(ModuloService moduloService) {
        this.service = moduloService;
    }

    @GetMapping
    public ResponseEntity<List<Modulo>> getModulosActivos() {
        return ResponseEntity.ok(this.service.listarModulosActivos());
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Modulo modulo) {
        this.service.crear(modulo);
        return ResponseEntity.ok("Módulo creado");
    }

    @PutMapping
    public ResponseEntity<Modulo> modificar(@RequestBody Modulo modulo) {
        try {
            this.service.modificar(modulo);
            modulo = this.service.obtenerPorCodigo(modulo.getCodModulo());
            return ResponseEntity.ok(modulo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    } 

}
