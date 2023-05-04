package com.encora.service;

import com.encora.model.Alumno;
import com.encora.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;

    public Flux<Alumno> findByEstado(String estado){
        return alumnoRepository.findByEstado(estado);
    }

    public Mono<Alumno> insertData(Alumno alumno) {
        return alumnoRepository.insertData(alumno.getId(),alumno.getNombre(), alumno.getApellido(), alumno.getEstado(), alumno.getEdad());
    }

    public Mono<Alumno> findById(Long id) {
        return alumnoRepository.findById(id);
    }
}
