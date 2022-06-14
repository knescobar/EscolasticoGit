package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.escolastico.educacion.model.MallaCarrera;
import ec.edu.espe.arquitectura.escolastico.educacion.service.MallaCarreraService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/mallaCarrera")
@RequiredArgsConstructor
public class MallaCarreraResource {

    private final MallaCarreraService mallaCarreraService;

    @GetMapping(path = "/buscar/carrera")
    public ResponseEntity<List<MallaCarrera>> getMallaCarrera(@RequestParam String nombreCarrera) {
        return ResponseEntity.ok(this.mallaCarreraService.listarMaLlaCarrera(nombreCarrera));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody MallaCarrera mallaCarrera) {
        this.mallaCarreraService.crear(mallaCarrera);
        return ResponseEntity.ok("Malla carrera creada");
    }

    @PutMapping
    public ResponseEntity<MallaCarrera> modificar(@RequestBody MallaCarrera mallaCarrera) {
        try {
            this.mallaCarreraService.modificar(mallaCarrera);
            mallaCarrera = this.mallaCarreraService.obtenerPorCodigo(mallaCarrera.getCodMateriacarrera());
            return ResponseEntity.ok(mallaCarrera);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
