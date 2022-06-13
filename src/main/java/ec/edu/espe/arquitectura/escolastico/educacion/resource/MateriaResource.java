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
import lombok.RequiredArgsConstructor;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.service.MateriaService;

@RestController
@RequestMapping(path = "/materia")
@RequiredArgsConstructor
public class MateriaResource {

    private final MateriaService materiaService;

    @GetMapping(path = "/buscar/departamento")
    public ResponseEntity<List<Materia>> getMateriaDepartamento(@RequestParam String idDepartamento) {
        return ResponseEntity.ok(this.materiaService.listarMateriaDepartamento(idDepartamento));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Materia materia) {
        this.materiaService.crear(materia);
        return ResponseEntity.ok("Materia creada");
    }

    @PutMapping
    public ResponseEntity<Materia> modificar(@RequestBody Materia materia) {
        try {
            this.materiaService.modificar(materia);
            materia = this.materiaService.obtenerPorCodigo(materia.getPk());
            return ResponseEntity.ok(materia);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
