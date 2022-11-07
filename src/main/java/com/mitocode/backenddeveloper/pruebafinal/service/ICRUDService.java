package com.mitocode.backenddeveloper.pruebafinal.service;

import java.util.List;

public interface ICRUDService<T, G> {

    G guardar(T entidad);
    List<G> listarTodos();
    void eliminar(Integer id);
    G listarPorId(Integer id);
    G actualizar(Integer id, T entidad);
}
