package com.mitocode.backenddeveloper.pruebafinal.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mitocode.backenddeveloper.pruebafinal.entity.DetalleMatricula;
import com.mitocode.backenddeveloper.pruebafinal.entity.Estudiante;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class MatriculaResponse {

    private Integer id;
    private LocalDate fechaMatricula;

    @JsonIncludeProperties(value= {"id"})
    private Estudiante estudiante;

    @JsonManagedReference
    private List<DetalleMatriculaResponse> detallesMatricula;
    private Boolean estado;
}
