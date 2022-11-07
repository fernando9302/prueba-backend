package com.mitocode.backenddeveloper.pruebafinal.service;

import com.mitocode.backenddeveloper.pruebafinal.entity.Estudiante;
import com.mitocode.backenddeveloper.pruebafinal.entity.Matricula;
import com.mitocode.backenddeveloper.pruebafinal.request.MatriculaRequest;
import com.mitocode.backenddeveloper.pruebafinal.response.CursoResponse;
import com.mitocode.backenddeveloper.pruebafinal.response.EstudianteResponse;
import com.mitocode.backenddeveloper.pruebafinal.response.MatriculaResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface IMatriculaService {

    MatriculaResponse registrar( MatriculaRequest matriculaRequest);

    Map<String, List<String>> obtenerEstudiantesyCursos();
}
