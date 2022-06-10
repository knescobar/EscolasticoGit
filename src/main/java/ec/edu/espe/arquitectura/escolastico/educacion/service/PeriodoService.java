package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.PeriodoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeriodoService {

    private final PeriodoRepository periodoRepository;

    public Periodo obtenerPorCodigo(Integer codigo) {
        Optional<Periodo> periodoOpt = this.periodoRepository.findById(codigo);
        if (periodoOpt.isPresent()) {
            return periodoOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Periodo periodo) {
        this.periodoRepository.save(periodo);
    }

    public void modificar(Periodo periodo) {
        Periodo periodoDB = this.obtenerPorCodigo(periodo.getCodPeriodo());
        periodoDB.setNombre(periodo.getNombre());
        periodoDB.setNivel(periodo.getNivel());
        periodoDB.setFechaInicio(periodo.getFechaInicio());
        periodoDB.setFechaFin(periodo.getFechaFin());
        periodo.setParciales(periodo.getParciales());
        this.periodoRepository.save(periodoDB);
    }

    public List<Periodo> listarPeriodoNivel(String nivel) {
        return this.periodoRepository.findByNivel(nivel);
    }
}