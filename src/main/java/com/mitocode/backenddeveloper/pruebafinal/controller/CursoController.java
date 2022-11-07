package com.mitocode.backenddeveloper.pruebafinal.controller;

import com.mitocode.backenddeveloper.pruebafinal.request.CursoRequest;
import com.mitocode.backenddeveloper.pruebafinal.response.CursoResponse;
import com.mitocode.backenddeveloper.pruebafinal.response.GenericoResponse;
import com.mitocode.backenddeveloper.pruebafinal.service.impl.CursoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoServiceImpl cursoServiceImpl;

    @GetMapping
    public ResponseEntity<GenericoResponse<List<CursoResponse>>> listarTodos(){
        return new ResponseEntity<>(new GenericoResponse<>(cursoServiceImpl.listarTodos()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericoResponse<CursoResponse>> listarPorId(@PathVariable("id") Integer id){
        return new ResponseEntity<>(new GenericoResponse<>(cursoServiceImpl.listarPorId(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericoResponse<CursoResponse>> guardar( @Valid @RequestBody CursoRequest cursoRequest){
        return new ResponseEntity<>(new GenericoResponse<>(cursoServiceImpl.guardar(cursoRequest)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericoResponse<CursoResponse>> actualizar(@PathVariable("id") Integer id, @Valid @RequestBody CursoRequest cursoRequest){
        return new ResponseEntity<>(new GenericoResponse<>(cursoServiceImpl.actualizar(id, cursoRequest)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericoResponse> eliminar(@PathVariable("id") Integer id){
        cursoServiceImpl.eliminar(id);
        return new ResponseEntity<>(new GenericoResponse(null), HttpStatus.OK);
    }

}
