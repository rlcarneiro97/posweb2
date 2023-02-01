package dev.fujioka.java.avancado.web.model;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class Disciplina implements Serializable {

    private Integer id;

    private String nome;

    private String cargaHoraria;

}