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

import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import ec.edu.espe.arquitectura.escolastico.educacion.service.CarreraService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/carrera")
@RequiredArgsConstructor
public class CarreraResource {

    private final CarreraService carreraService;

    @GetMapping(path = "/buscar/nivel")
    public ResponseEntity<List<Carrera>> getCarrerasNivel(@RequestParam String idNivel) {
        return ResponseEntity.ok(this.carreraService.listarCarreraNivel(idNivel));
    }

    @GetMapping(path = "/buscar/modalidad")
    public ResponseEntity<List<Carrera>> getCarrerasModalidad(@RequestParam String idModalidad) {
        return ResponseEntity.ok(this.carreraService.listarCarreraModalidad(idModalidad));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Carrera carrera) {
        try {
            this.carreraService.crear(carrera);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Carrera> modificar(@RequestBody Carrera carrera) {
        try {
            this.carreraService.modificar(carrera);
            carrera = this.carreraService.obtenerPorCodigo(carrera.getCodCarrera());
            return ResponseEntity.ok(carrera);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
