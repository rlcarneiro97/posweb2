package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Query("select a from Professor a order by a.nome ASC")
    public List<Professor> listarOrdenadoPorNome();

    public List<Professor> findAllByOrderByNomeAsc();

    @Query("select a from Professor a where a.nome like %:nome%")
    public List<Professor> buscarProfessorPorNomeLike(@Param("nome") String nome);

}
