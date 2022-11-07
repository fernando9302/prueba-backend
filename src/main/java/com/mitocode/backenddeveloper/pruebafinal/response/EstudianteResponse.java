package com.mitocode.backenddeveloper.pruebafinal.response;

import lombok.Data;

import javax.persistence.Column;

@Data
public class EstudianteResponse {

    private Integer id;
    private String nombres;
    private String apellidos;
    private String dni;
    private Integer edad;
}
