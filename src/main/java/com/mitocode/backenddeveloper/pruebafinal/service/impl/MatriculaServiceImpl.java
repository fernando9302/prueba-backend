package com.mitocode.backenddeveloper.pruebafinal.service.impl;

import com.mitocode.backenddeveloper.pruebafinal.entity.DetalleMatricula;
import com.mitocode.backenddeveloper.pruebafinal.entity.Estudiante;
import com.mitocode.backenddeveloper.pruebafinal.entity.Matricula;
import com.mitocode.backenddeveloper.pruebafinal.repository.ICursoRepository;
import com.mitocode.backenddeveloper.pruebafinal.repository.IMatriculaRepository;
import com.mitocode.backenddeveloper.pruebafinal.request.EstudianteRequest;
import com.mitocode.backenddeveloper.pruebafinal.request.MatriculaRequest;
import com.mitocode.backenddeveloper.pruebafinal.response.CursoResponse;
import com.mitocode.backenddeveloper.pruebafinal.response.EstudianteResponse;
import com.mitocode.backenddeveloper.pruebafinal.response.MatriculaResponse;
import com.mitocode.backenddeveloper.pruebafinal.service.IEstudianteService;
import com.mitocode.backenddeveloper.pruebafinal.service.IMatriculaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private IMatriculaRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public MatriculaResponse registrar(MatriculaRequest matriculaRequest) {
        Matricula matricula = new Matricula();
        matricula.setFechaMatricula(matriculaRequest.getFechaMatricula());
        matricula.setEstudiante(new Estudiante(matriculaRequest.getIdEstudiante()));
        matricula.setEstado(true);
        matricula.setDetallesMatricula(matriculaRequest.getDetallesMatricula().stream().map(x-> new DetalleMatricula(matricula, x.getIdCurso(), x.getAula())).collect(Collectors.toList()));
        repository.save(matricula);
        return modelMapper.map(repository.findById(matricula.getId()).orElse(new Matricula()), MatriculaResponse.class);
    }

    @Override
    public Map<String, List<String>> obtenerEstudiantesyCursos() {
       return repository.findAll().stream().map(x->x.getDetallesMatricula()).flatMap(x->x.stream()).collect(Collectors.groupingBy(x->x.getCurso().getNombre(), Collectors.mapping(x->x.getMatricula().getEstudiante().getNombres(), Collectors.toList())));
    }
}
