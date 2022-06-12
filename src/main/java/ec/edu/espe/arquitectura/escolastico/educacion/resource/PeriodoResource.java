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

import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import ec.edu.espe.arquitectura.escolastico.educacion.service.PeriodoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/periodo")
@RequiredArgsConstructor
public class PeriodoResource {

    private final PeriodoService periodoService;

    @GetMapping(path = "/buscar/nivel")
    public ResponseEntity<List<Periodo>> getPeriodos(@RequestParam String idNivel) {
        return ResponseEntity.ok(this.periodoService.listarPeriodoNivel(idNivel));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Periodo periodo) {
        try {
            this.periodoService.crear(periodo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Periodo> modificar(@RequestBody Periodo periodo) {
        try {
            this.periodoService.modificar(periodo);
            periodo = this.periodoService.obtenerPorCodigo(periodo.getCodPeriodo());
            return ResponseEntity.ok(periodo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

}
