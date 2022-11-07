package com.mitocode.backenddeveloper.pruebafinal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 5)
    private String siglas;

    private Boolean estado;

    public Curso(Integer id){
        this.id = id;
    }
}
