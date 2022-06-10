package ec.edu.espe.arquitectura.escolastico.educacion.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.MateriaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.escolastico.organizacionFisica.dao.AulaRepository;

@Service
public class MateriaService {

    private MateriaRepository materiaRepository;
    private NrcRepository nrcRepository;
    private AulaRepository aulaRepository;

    public MateriaService(MateriaRepository materiaRepository, NrcRepository nrcRepository,
            AulaRepository aulaRepository) 
    {

        this.materiaRepository = materiaRepository;
        this.nrcRepository = nrcRepository;
        this.aulaRepository = aulaRepository;
    } 

    
    
}
