package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor salvar(Professor professor){
        return professorRepository.save(professor);
    }

    public List<Professor> listarProfessores(){
        return professorRepository.findAll();
    }

    public Professor consultarPorId(int id){
        return professorRepository.findById(id).orElseThrow();
    }

    public void excluir(int id){
        professorRepository.deleteById(id);
    }

    public Professor alterar(Professor professor){
        if(Objects.isNull(professor.getId())){
            throw new RuntimeException("ID não encontrado.");
        }
        return professorRepository.save(professor);
    }

    public List<Professor> buscarProfessorLike(String nome){
        return professorRepository.buscarProfessorPorNomeLike(nome);
    }
}
