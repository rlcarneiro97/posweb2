package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

        @Autowired
        private ProfessorService professorService;

        @PostMapping
        public ResponseEntity<Professor> salvar(@RequestBody Professor professor){
            return ResponseEntity.ok(professorService.salvar(professor));
        }

        @GetMapping
        public ResponseEntity<List<Professor>> getProfessores(){
            return ResponseEntity.ok(professorService.listarProfessores());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Professor> consultarPorId(@PathVariable int id){
            return ResponseEntity.ok(professorService.consultarPorId(id));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Professor> deletePorId(@PathVariable int id){
            professorService.excluir(id);
            return ResponseEntity.ok().build();
        }

        @PutMapping
        public ResponseEntity<Professor> alterar(@RequestBody Professor professor) {
            if (Objects.isNull(professor.getId())) {
                throw new RuntimeException("id não preenchido");
            }
            return ResponseEntity.ok(professorService.alterar(professor));
        }

        @GetMapping("/like/{nome}")
        public ResponseEntity<List<Professor>> listarPorLike(@PathVariable String nome){
            return ResponseEntity.ok(professorService.buscarProfessorLike(nome));
        }
}
