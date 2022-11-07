package com.mitocode.backenddeveloper.pruebafinal.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.mitocode.backenddeveloper.pruebafinal.entity.Curso;
import com.mitocode.backenddeveloper.pruebafinal.entity.Matricula;
import lombok.Data;

@Data
public class DetalleMatriculaResponse {

    private Integer id;
    @JsonBackReference
    private Matricula matricula;

    @JsonIncludeProperties(value= {"id"})
    private Curso curso;
    private String aula;
}
