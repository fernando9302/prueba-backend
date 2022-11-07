package com.mitocode.backenddeveloper.pruebafinal.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EstudianteRequest {

    @NotNull(message = "El campo nombres del estudiante no debe ser nulo")
    @NotEmpty(message = "El campo nombres del estudiante no debe ser vacío")
    @Size(max = 50, message = "El campo nombres del estudiante debe ser de máximo 50 caracteres")
    private String nombres;

    @NotNull(message = "El campo apellidos del estudiante no debe ser nulo")
    @NotEmpty(message = "El campo apellidos del estudiante no debe ser vacío")
    @Size(max = 50, message = "El campo apellidos del estudiante debe ser de máximo 50 caracteres")
    private String apellidos;

    @NotNull(message = "El campo dni del estudiante no debe ser nulo")
    @NotEmpty(message = "El campo dni del estudiante no debe ser vacío")
    @Size(max = 8, message = "El campo dni del estudiante debe ser de máximo 8 caracteres")
    private String dni;

    @NotNull(message = "El campo edad del estudiante no debe ser nulo")
    private Integer edad;
}
