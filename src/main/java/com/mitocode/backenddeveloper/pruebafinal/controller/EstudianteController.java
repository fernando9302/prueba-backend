package com.mitocode.backenddeveloper.pruebafinal.controller;

import com.mitocode.backenddeveloper.pruebafinal.request.EstudianteRequest;
import com.mitocode.backenddeveloper.pruebafinal.response.EstudianteResponse;
import com.mitocode.backenddeveloper.pruebafinal.response.GenericoResponse;
import com.mitocode.backenddeveloper.pruebafinal.service.impl.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteServiceImpl estudianteServiceImpl;

    @GetMapping
    public ResponseEntity<GenericoResponse<List<EstudianteResponse>>> listarTodos(){
        return new ResponseEntity<>(new GenericoResponse<>(estudianteServiceImpl.listarTodos()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericoResponse<EstudianteResponse>> listarPorId(@PathVariable("id") Integer id){
        return new ResponseEntity<>(new GenericoResponse<>(estudianteServiceImpl.listarPorId(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericoResponse<EstudianteResponse>> guardar(@Valid  @RequestBody EstudianteRequest estudianteRequest){
        return new ResponseEntity<>(new GenericoResponse<>(estudianteServiceImpl.guardar(estudianteRequest)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericoResponse<EstudianteResponse>> actualizar(@PathVariable("id") Integer id, @Valid  @RequestBody EstudianteRequest estudianteRequest){
        return new ResponseEntity<>(new GenericoResponse<>(estudianteServiceImpl.actualizar(id, estudianteRequest)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericoResponse> eliminar(@PathVariable("id") Integer id){
        estudianteServiceImpl.eliminar(id);
        return new ResponseEntity<>(new GenericoResponse(null), HttpStatus.OK);
    }

    @GetMapping("/edad")
    public ResponseEntity<GenericoResponse<List<EstudianteResponse>>> listarPorEdad(){
        return new ResponseEntity<>(new GenericoResponse<>(estudianteServiceImpl.listarDescendente()), HttpStatus.OK);
    }

}