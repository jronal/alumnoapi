package com.encora;

import com.encora.model.Alumno;
import com.encora.service.AlumnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@SpringBootTest
class AlumnoApplicationTests {

	@Autowired
	AlumnoService alumnoService;

	@Test
	void insertDataTest() {
		Alumno alumno = new Alumno(3L, "Pedro", "García", "Inactivo", 23);

		//given

		//when
		var alumnoMono = alumnoService.insertData(alumno).log();

		//then
		StepVerifier.create(alumnoMono)
				.expectNextCount(1)
				.verifyComplete();
	}


	@Test
	void findByEstadoTest() {
		Alumno alumno = new Alumno(1L, "Jose", "Flores", "activo", 23);

		var alumnoMono = alumnoService.insertData(alumno).subscribe();

		//when
		var namesFlux = alumnoService.findByEstado("activo").log();

		//then
		StepVerifier.create(namesFlux)
				.expectNextCount(1)
				.verifyComplete();
	}

}
