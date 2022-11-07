package com.mitocode.backenddeveloper.pruebafinal.service;

import com.mitocode.backenddeveloper.pruebafinal.request.EstudianteRequest;
import com.mitocode.backenddeveloper.pruebafinal.response.EstudianteResponse;

import java.util.List;

public interface IEstudianteService extends ICRUDService<EstudianteRequest, EstudianteResponse> {

    List<EstudianteResponse> listarDescendente();
}
