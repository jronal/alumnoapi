package com.encora.controller;

import com.encora.exception.ValidationException;
import com.encora.model.Alumno;
import com.encora.service.AlumnoService;
import com.encora.util.WrapperResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/alumno")
@Slf4j
@RequiredArgsConstructor
public class AlumnoController {
    private static final String ESTADO_ACTIVO = "activo";

    private final AlumnoService alumnoService;

    @PostMapping
    public Mono<Object> crearAlumno(@Valid @RequestBody Alumno alumno) {
        return alumnoService.findById(alumno.getId()).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(existingAlumno -> {
                    if (existingAlumno.isPresent()) {
                        return Mono.error(new ValidationException("Ya existe un alumno con ese ID"));
                    } else {
                        return alumnoService.insertData(alumno)
                                .then(Mono.just(ResponseEntity.status(HttpStatus.CREATED)
                                        .body(WrapperResponseUtil.responseOK(HttpStatus.CREATED, "Operacion exitosa"))));
                    }

                });
    }

    @GetMapping
    public Flux<Alumno> obtenerAlumnosActivos() {
        return alumnoService.findByEstado(ESTADO_ACTIVO);
    }

}
