package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.dto.DisciplinaDTO;
import dev.fujioka.java.avancado.web.model.Disciplina;
import dev.fujioka.java.avancado.web.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    public DisciplinaDTO salvar(Disciplina disciplina){
        disciplina = disciplinaRepository.save(disciplina);
        jmsTemplate.convertAndSend("disciplina_queue", disciplina);
        return DisciplinaDTO.builder()
                .nome(disciplina.getNome())
                .cargaHoraria(disciplina.getCargaHoraria())
                .build();
    }

    public List<Disciplina> listarDisciplinas(){
        return disciplinaRepository.findAll();
    }

    public Disciplina consultarPorId(int id){
        return disciplinaRepository.findById(id).orElseThrow();
    }

    public void excluir(int id){
        disciplinaRepository.deleteById(id);
    }

    public Disciplina alterar(Disciplina disciplina){
        if(Objects.isNull(disciplina.getId())){
            throw new RuntimeException("ID não encontrado.");
        }
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> buscarDisciplinaLike(String nome){
        return disciplinaRepository.buscarDisciplinaPorNomeLike(nome);
    }
}
