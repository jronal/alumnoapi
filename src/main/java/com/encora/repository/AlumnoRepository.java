package com.encora.repository;

import com.encora.model.Alumno;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AlumnoRepository extends R2dbcRepository<Alumno, Long> {
    @Query("SELECT * FROM alumno WHERE estado = :estado")
    Flux<Alumno> findByEstado(String estado);


    @Modifying
    @Query(value = "insert into alumno(id, nombre, apellido, estado, edad) VALUES (:id, :nombre, :apellido, :estado, :edad)")
    @Transactional
    Mono<Alumno> insertData(@Param("id")Long id,
                            @Param("nombre")String nombre,
                            @Param("apellido")String apellido,
                            @Param("estado")String estado,
                            @Param("edad")Integer edad );
}
