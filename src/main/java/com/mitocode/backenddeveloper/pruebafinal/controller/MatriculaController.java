package com.mitocode.backenddeveloper.pruebafinal.controller;

import com.mitocode.backenddeveloper.pruebafinal.request.MatriculaRequest;
import com.mitocode.backenddeveloper.pruebafinal.response.GenericoResponse;
import com.mitocode.backenddeveloper.pruebafinal.response.MatriculaResponse;
import com.mitocode.backenddeveloper.pruebafinal.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl matriculaService;

    @PostMapping
    public ResponseEntity<GenericoResponse<MatriculaResponse>> registrar(@Valid @RequestBody MatriculaRequest matriculaRequest){
        return new ResponseEntity<>(new GenericoResponse<>(matriculaService.registrar(matriculaRequest)), HttpStatus.OK);
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<GenericoResponse<Map<String, List<String>>>> listarEstudiantesyCursos(){
        return new ResponseEntity<>(new GenericoResponse<>(matriculaService.obtenerEstudiantesyCursos()), HttpStatus.OK);
    }
}
