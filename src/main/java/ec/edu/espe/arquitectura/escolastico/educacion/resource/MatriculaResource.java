package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import java.util.List;

import ec.edu.espe.arquitectura.escolastico.educacion.dto.MatriculaDto;
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

import javax.validation.Valid;

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
    public ResponseEntity<String> crear(@Valid @RequestBody MatriculaDto matricula) {
        this.matriculaService.crear(matricula);
        return ResponseEntity.ok("Matricula creada");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@Valid @RequestBody MatriculaDto matriculaDto) {
        this.matriculaService.modificar(matriculaDto);
        return ResponseEntity.ok("Matricula Modificada");
    }
}