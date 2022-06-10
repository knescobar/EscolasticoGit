package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.escolastico.educacion.service.NrcService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/nrc")
@RequiredArgsConstructor
public class NrcResource {

    private final NrcService nrcService;

}
