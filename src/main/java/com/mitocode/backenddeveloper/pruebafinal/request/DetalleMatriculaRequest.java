package com.mitocode.backenddeveloper.pruebafinal.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class DetalleMatriculaRequest {

    @NotNull(message = "El campo id curso del detalle matricula no debe ser nulo")
    private Integer idCurso;

    @NotNull(message = "El campo aula del detalle de matricula no debe ser nulo")
    @NotEmpty(message = "El campo aula del detalle de matricula no debe ser vacío")
    @Size(max = 20, message = "El campo aula del detalle de matricula debe ser de máximo 20 caracteres")
    private String aula;
}
