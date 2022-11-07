package com.mitocode.backenddeveloper.pruebafinal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nombres;

    @Column(length = 50)
    private String apellidos;

    @Column(length = 8)
    private String dni;

    private Integer edad;

    public Estudiante(Integer id){
        this.id = id;
    }
}
