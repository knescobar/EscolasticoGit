package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.TipoCalificacionEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.CalificacionRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MateriaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MatriculaNrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MatriculaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Calificacion;
import ec.edu.espe.arquitectura.escolastico.educacion.model.CalificacionPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.CrearException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalificacionService {
    private final static MathContext PRECISION_NOTA = new MathContext(4, RoundingMode.HALF_UP);

    private final CalificacionRepository calificacionRepository;
    private final MatriculaNrcRepository matriculaNrcRepository;
    private final MateriaRepository materiaRepository;
    private final NrcRepository nrcRepository;

    public Calificacion obtenerPorCodigo(CalificacionPK pk) {
        Optional<Calificacion> calificacionOpt = this.calificacionRepository.findById(pk);
        if (calificacionOpt.isPresent()) {
            return calificacionOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Calificacion calificacion) {

        if (calificacion.getPk() == null) {
            throw new CrearException(
                    "Error al crear la calificacion, la información de la matrícula y estudiante es requerida");
        }
        BigDecimal promedio = calcularPromedio(calificacion);
        calificacion.setPromedio(promedio);
        Nrc nrcDB = this.nrcRepository.findByPkCodNrc(
                calificacion.getPk().getCodNrc());
        Materia materiaDB = this.materiaRepository.findByPkCodMateria(
                nrcDB.getPk().getCodMateria());

        MatriculaNrc matriculaNrcDB = this.matriculaNrcRepository.findByPkCodMatriculaAndPkCodNrcAndPkCodPersona(
                calificacion.getPk().getCodMatricula(), calificacion.getPk().getCodNrc(),
                calificacion.getPk().getCodPersona());
        BigDecimal ponderacion = materiaDB.getPonderacion();
        ponderacion = ponderacion.multiply(new BigDecimal("0.7"));

        if (promedio.compareTo(ponderacion) == 0) {
            matriculaNrcDB.setEstado(TipoCalificacionEnum.APROBADO.getValor());
            calificacion.setObservacion(TipoCalificacionEnum.APROBADO.getTexto());
        } else if (promedio.compareTo(ponderacion) == 1) {
            matriculaNrcDB.setEstado(TipoCalificacionEnum.APROBADO.getValor());
            calificacion.setObservacion(TipoCalificacionEnum.APROBADO.getTexto());
        } else {
            matriculaNrcDB.setEstado(TipoCalificacionEnum.REPROBADO.getValor());
            calificacion.setObservacion(TipoCalificacionEnum.REPROBADO.getTexto());
        }
        this.matriculaNrcRepository.save(matriculaNrcDB);
        this.calificacionRepository.save(calificacion);

    }

    public void modificar(Calificacion calificacion) {
        Calificacion calificacionDB = this.obtenerPorCodigo(calificacion.getPk());
        calificacionDB.setNota1(calificacion.getNota1());
        calificacionDB.setNota2(calificacion.getNota2());
        calificacionDB.setNota3(calificacion.getNota3());
        calificacionDB.setNota4(calificacion.getNota4());
        calificacionDB.setNota5(calificacion.getNota5());
        calificacionDB.setNota6(calificacion.getNota6());
        calificacionDB.setNota7(calificacion.getNota7());
        calificacionDB.setNota8(calificacion.getNota8());
        calificacionDB.setNota9(calificacion.getNota9());
        calificacionDB.setNota10(calificacion.getNota10());
        BigDecimal promedio = calcularPromedio(calificacion);
        calificacionDB.setPromedio(promedio);
        Nrc nrcDB = this.nrcRepository.findByPkCodNrc(
                calificacion.getPk().getCodNrc());
        Materia materiaDB = this.materiaRepository.findByPkCodMateria(
                nrcDB.getPk().getCodMateria());

        MatriculaNrc matriculaNrcDB = this.matriculaNrcRepository.findByPkCodMatriculaAndPkCodNrcAndPkCodPersona(
                calificacion.getPk().getCodMatricula(), calificacion.getPk().getCodNrc(),
                calificacion.getPk().getCodPersona());
        BigDecimal ponderacion = materiaDB.getPonderacion();
        ponderacion = ponderacion.multiply(new BigDecimal("0.7"));

        if (promedio.compareTo(ponderacion) == 0) {
            matriculaNrcDB.setEstado(TipoCalificacionEnum.APROBADO.getValor());
            calificacionDB.setObservacion(TipoCalificacionEnum.APROBADO.getTexto());
        } else if (promedio.compareTo(ponderacion) == 1) {
            matriculaNrcDB.setEstado(TipoCalificacionEnum.APROBADO.getValor());
            calificacionDB.setObservacion(TipoCalificacionEnum.APROBADO.getTexto());
        } else {
            matriculaNrcDB.setEstado(TipoCalificacionEnum.REPROBADO.getValor());
            calificacionDB.setObservacion(TipoCalificacionEnum.REPROBADO.getTexto());
        }
        this.matriculaNrcRepository.save(matriculaNrcDB);
        this.calificacionRepository.save(calificacionDB);
    }

    public List<Calificacion> listarCalificacionesEstudianteNrc(Integer codPersona, Integer codNrc) {
        return this.calificacionRepository.findByPkCodPersonaAndPkCodNrcOrderByMatriculaNrcNrcNombre(codPersona,
                codNrc);
    }

    public List<Calificacion> listarCalifiacionesNrc(Integer codNrc) {
        return this.calificacionRepository.findByPkCodNrc(codNrc);
    }

    private BigDecimal calcularPromedio(Calificacion calificacion) {
        List<BigDecimal> notasActuales = Stream.of(
                calificacion.getNota1(),
                calificacion.getNota2(),
                calificacion.getNota3(),
                calificacion.getNota4(),
                calificacion.getNota5(),
                calificacion.getNota6(),
                calificacion.getNota7(),
                calificacion.getNota8(),
                calificacion.getNota9(),
                calificacion.getNota10())
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        BigDecimal total = notasActuales.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return total.divide(BigDecimal.valueOf(notasActuales.size()), PRECISION_NOTA);
    }
}