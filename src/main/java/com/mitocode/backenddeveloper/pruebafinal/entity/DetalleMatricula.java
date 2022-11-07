package com.mitocode.backenddeveloper.pruebafinal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class DetalleMatricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_matricula")
    private Matricula matricula;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @Column(length = 20)
    private String aula;

    public DetalleMatricula(Matricula matricula, Integer idCurso, String aula){
        this.matricula =matricula;
        this.curso = new Curso(idCurso);
        this.aula = aula;
    }

}
