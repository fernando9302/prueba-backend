package com.mitocode.backenddeveloper.pruebafinal.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CursoRequest {

    @NotNull(message = "El campo nombre del curso no debe ser nulo")
    @NotEmpty(message = "El campo nombre del curso no debe ser vacío")
    @Size(max = 50, message = "El campo nombre del curso debe ser de máximo 50 caracteres")
    private String nombre;

    @NotNull(message = "El campo siglas del curso no debe ser nulo")
    @NotEmpty(message = "El campo siglas del curso no debe ser vacío")
    @Size(max = 5, message = "El campo siglas del curso debe ser de máximo 5 caracteres")
    private String siglas;

}
