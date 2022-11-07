package com.mitocode.backenddeveloper.pruebafinal.service.impl;

import com.mitocode.backenddeveloper.pruebafinal.entity.Estudiante;
import com.mitocode.backenddeveloper.pruebafinal.exception.ErrorNegocioException;
import com.mitocode.backenddeveloper.pruebafinal.repository.IEstudianteRepository;
import com.mitocode.backenddeveloper.pruebafinal.request.EstudianteRequest;
import com.mitocode.backenddeveloper.pruebafinal.response.EstudianteResponse;
import com.mitocode.backenddeveloper.pruebafinal.service.IEstudianteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl extends GenericoService<EstudianteRequest, EstudianteResponse> implements IEstudianteService {

    @Autowired
    private IEstudianteRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EstudianteResponse guardar(EstudianteRequest entidad) {
        validarEstudianteRepetido(entidad, 0);
        Estudiante estudiante = modelMapper.map(entidad, Estudiante.class);
        repository.save(estudiante);
        return modelMapper.map(repository.findById(estudiante.getId()).orElse(new Estudiante()), EstudianteResponse.class);
    }

    private void validarEstudianteRepetido(EstudianteRequest entidad, Integer id){
        if(esEstudianteRepetido(entidad.getDni(), id))
            throw new ErrorNegocioException("El estudiante ya existe");
    }

    private Boolean esEstudianteRepetido(String dni, Integer id){
        return repository.findByDniAndIdNot(dni, id).isPresent();
    }

    @Override
    public List<EstudianteResponse> listarTodos() {
        return repository.findAll().stream().map(x->modelMapper.map(x, EstudianteResponse.class)).collect(Collectors.toList());
    }


    @Override
    public void eliminar(Integer id) {
        validarExistencia(id);
        repository.deleteById(id);
    }

    @Override
    public EstudianteResponse listarPorId(Integer id) {
        Estudiante estudiante = validarExistencia(id);
        if(estudiante != null){
            return modelMapper.map(estudiante, EstudianteResponse.class);
        }
        return null;
    }

    private Estudiante validarExistencia(Integer id)
    {
        Estudiante estudiante = repository.findById(id).orElse(null);
        if(estudiante == null)
            throw new ErrorNegocioException("El estudiante no existe");
        return estudiante;
    }

    @Override
    public EstudianteResponse actualizar(Integer id, EstudianteRequest entidad) {
        validarEstudianteRepetido(entidad, id);
        Estudiante estudiante = validarExistencia(id);
        modelMapper.map(entidad, estudiante);
        repository.save(estudiante);
        return modelMapper.map(estudiante, EstudianteResponse.class);
    }

    @Override
    public List<EstudianteResponse> listarDescendente() {
        return repository.findAll().stream().sorted(Comparator.comparing(Estudiante::getEdad).reversed()).map(x->modelMapper.map(x, EstudianteResponse.class)).collect(Collectors.toList());
    }
}