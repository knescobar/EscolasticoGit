package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Departamento;
import ec.edu.espe.arquitectura.escolastico.educacion.service.DepartamentoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/departamento")
@RequiredArgsConstructor
public class DepartamentoResource {

    private final DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> getDepartamentos() {
        return ResponseEntity.ok(this.departamentoService.listarDepartamentos());
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Departamento departamento) {
        this.departamentoService.crear(departamento);
        return ResponseEntity.ok("Departamento creado");
    }

    @PutMapping
    public ResponseEntity<Departamento> modificar(@RequestBody Departamento departamento) {
        try {
            this.departamentoService.modificar(departamento);
            departamento = this.departamentoService.obtenerPorCodigo(departamento.getCodDepartamento());
            return ResponseEntity.ok(departamento);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}