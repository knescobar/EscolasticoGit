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

import ec.edu.espe.arquitectura.escolastico.educacion.model.Calificacion;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.service.CalificacionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/calificacion")
@RequiredArgsConstructor
public class CalificacionResoruce {
    private final CalificacionService calificacionService;

    @GetMapping(path = "/buscar/nrc")
    public ResponseEntity<List<Calificacion>> getCalificacionNrc(@RequestParam Integer nrc) {
        return ResponseEntity.ok(this.calificacionService.listarCalifiacionesNrc(nrc));
    }

    @GetMapping(path = "/buscar/estudiante")
    public ResponseEntity<Calificacion> getCalificacionNrc(@RequestParam Integer codPersona, Integer nrc) {
        return ResponseEntity.ok(this.calificacionService.listarCalificacionesEstudianteNrc(codPersona, nrc));
    }

    @GetMapping(path = "/buscar/nrcApr")
    public ResponseEntity<List<MatriculaNrc>> getNrcAprobados(@RequestParam String periodo, Integer estudiante) {
        return ResponseEntity.ok(this.calificacionService.listarNrcAprobadosEstudiante(periodo, estudiante));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Calificacion calificacion) {
        try {
            this.calificacionService.crear(calificacion);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Calificacion> modificar(@RequestBody Calificacion calificacion) {
        try {
            this.calificacionService.modificar(calificacion);
            calificacion = this.calificacionService.obtenerPorCodigo(calificacion.getPk());
            return ResponseEntity.ok(calificacion);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
