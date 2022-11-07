package com.mitocode.backenddeveloper.pruebafinal.service.impl;

import com.mitocode.backenddeveloper.pruebafinal.entity.Curso;
import com.mitocode.backenddeveloper.pruebafinal.exception.ErrorNegocioException;
import com.mitocode.backenddeveloper.pruebafinal.repository.ICursoRepository;
import com.mitocode.backenddeveloper.pruebafinal.request.CursoRequest;
import com.mitocode.backenddeveloper.pruebafinal.response.CursoResponse;
import com.mitocode.backenddeveloper.pruebafinal.service.ICursoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl extends GenericoService<CursoRequest, CursoResponse> implements ICursoService {

    @Autowired
    private ICursoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CursoResponse guardar(CursoRequest entidad) {
        validarCursoRepetido(entidad, 0);
        Curso curso = modelMapper.map(entidad, Curso.class);
        curso.setEstado(true);
        repository.save(curso);
        return modelMapper.map(repository.findById(curso.getId()).orElse(new Curso()), CursoResponse.class);
    }

    private void validarCursoRepetido(CursoRequest entidad, Integer id){
        if(esCursoRepetido(entidad.getNombre(), id))
            throw new ErrorNegocioException("El curso ya existe");
    }

    private Boolean esCursoRepetido(String nombres, Integer id){
        return repository.findByNombreAndIdNot(nombres, id).isPresent();
    }

    @Override
    public List<CursoResponse> listarTodos() {
        return repository.findAll().stream().map(x->modelMapper.map(x, CursoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void eliminar(Integer id) {
        validarExistencia(id);
        repository.deleteById(id);
    }

    private Curso validarExistencia(Integer id){
        Curso curso = repository.findById(id).orElse(null);
        if(curso == null)
            throw new ErrorNegocioException("El curso no existe");
        return curso;
    }

    @Override
    public CursoResponse listarPorId(Integer id) {
        Curso curso = repository.findById(id).orElse(null);
        if(curso != null){
            return modelMapper.map(curso, CursoResponse.class);
        }
        return null;
    }

    @Override
    public CursoResponse actualizar(Integer id, CursoRequest entidad) {
        validarCursoRepetido(entidad, id);
        Curso curso = validarExistencia(id);
        modelMapper.map(entidad, curso);
        repository.save(curso);
        return modelMapper.map(curso, CursoResponse.class);
    }
}
