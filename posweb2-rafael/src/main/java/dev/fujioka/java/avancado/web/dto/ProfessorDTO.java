package dev.fujioka.java.avancado.web.dto;

import java.io.Serializable;
import lombok.Builder;

@Builder
@SuppressWarnings("unused")
public class ProfessorDTO implements Serializable{

        private Integer id;
        private String nome;
        private String matricula;
}

