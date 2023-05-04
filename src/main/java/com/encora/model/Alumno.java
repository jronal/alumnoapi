package com.encora.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alumno {

    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private String estado;
    private Integer edad;


    public static void main(String[] args) {

    }
}