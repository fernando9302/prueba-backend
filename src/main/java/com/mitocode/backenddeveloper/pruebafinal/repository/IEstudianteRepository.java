package com.mitocode.backenddeveloper.pruebafinal.repository;

import com.mitocode.backenddeveloper.pruebafinal.entity.Curso;
import com.mitocode.backenddeveloper.pruebafinal.entity.Estudiante;

import java.util.Optional;

public interface IEstudianteRepository extends IGenericoRepository<Estudiante, Integer> {

    Optional<Estudiante> findByDniAndIdNot(String nombres, Integer id);
}
