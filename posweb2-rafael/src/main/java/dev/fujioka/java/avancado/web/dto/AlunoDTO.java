package dev.fujioka.java.avancado.web.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AlunoDTO implements Serializable{

        private Integer id;
        private String nome;
        private String matricula;
}

