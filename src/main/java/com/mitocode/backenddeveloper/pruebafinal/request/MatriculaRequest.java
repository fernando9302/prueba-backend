package com.mitocode.backenddeveloper.pruebafinal.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class MatriculaRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "El campo fecha matrícula de la matrícula no debe ser nulo")
    private LocalDate fechaMatricula;

    @NotNull(message = "El campo id estudiante de la matricula no debe ser nulo")
    private Integer idEstudiante;

    @NotNull(message = "El campo detalle de la matricula no debe ser nulo")
    private List<DetalleMatriculaRequest> detallesMatricula;
}
