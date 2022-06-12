package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
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
}