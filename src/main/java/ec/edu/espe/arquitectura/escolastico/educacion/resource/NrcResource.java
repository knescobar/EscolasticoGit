package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.service.NrcService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/nrc")
@RequiredArgsConstructor
public class NrcResource {

    private final NrcService nrcService;

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Nrc nrc) {
        this.nrcService.crear(nrc);
        return ResponseEntity.ok("NRC creado");
    }

    @GetMapping
    public ResponseEntity<List<Nrc>> getNrc() {
        return ResponseEntity.ok(this.nrcService.listarNrc());
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody Nrc nrc) {
        this.nrcService.modificar(nrc);
        return ResponseEntity.ok().build();
    }

}
