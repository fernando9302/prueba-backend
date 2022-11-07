package com.mitocode.backenddeveloper.pruebafinal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate fechaMatricula;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetalleMatricula> detallesMatricula;
    private Boolean estado;
}
