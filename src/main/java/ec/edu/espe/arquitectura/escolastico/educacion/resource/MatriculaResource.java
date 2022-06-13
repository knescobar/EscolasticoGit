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

import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.service.MatriculaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/matricula")
@RequiredArgsConstructor
public class MatriculaResource {
    private final MatriculaService matriculaService;

    @GetMapping(path = "/buscar/periodoPersona")
    public ResponseEntity<List<Matricula>> getMatriculaPeriodoPersona(@RequestParam String periodo,
            @RequestParam String estudianteNombre) {
        return ResponseEntity.ok(this.matriculaService.listarMatriculasPersonaPeriodo(periodo, estudianteNombre));
    }

    @GetMapping(path = "/buscar/persona")
    public ResponseEntity<List<Matricula>> getMatriculaPersona(@RequestParam String estudianteNombre) {
        return ResponseEntity.ok(this.matriculaService.listarMatriculasPersona(estudianteNombre));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Matricula matricula) {
        try {
            this.matriculaService.crear(matricula);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Matricula> modificar(@RequestBody Matricula matricula) {
        try {
            this.matriculaService.modificar(matricula);
            matricula = this.matriculaService.obtenerPorCodigo(matricula.getPk());
            return ResponseEntity.ok(matricula);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}