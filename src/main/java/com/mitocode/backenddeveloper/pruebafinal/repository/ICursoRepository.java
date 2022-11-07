package com.mitocode.backenddeveloper.pruebafinal.repository;

import com.mitocode.backenddeveloper.pruebafinal.entity.Curso;

import java.util.Optional;

public interface ICursoRepository extends IGenericoRepository<Curso, Integer> {

    Optional<Curso> findByNombreAndIdNot(String nombres, Integer id);
}
