package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.model.Disciplina;
import dev.fujioka.java.avancado.web.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {

        @Autowired
        private DisciplinaService disciplinaService;

        @PostMapping
        public ResponseEntity<Disciplina> salvar(@RequestBody Disciplina disciplina){
            return ResponseEntity.ok(disciplinaService.salvar(disciplina));
        }

        @GetMapping
        public ResponseEntity<List<Disciplina>> getDisciplinas(){
            return ResponseEntity.ok(disciplinaService.listarDisciplinas());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Disciplina> consultarPorId(@PathVariable int id){
            return ResponseEntity.ok(disciplinaService.consultarPorId(id));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Disciplina> deletePorId(@PathVariable int id){
            disciplinaService.excluir(id);
            return ResponseEntity.ok().build();
        }

        @PutMapping
        public ResponseEntity<Disciplina> alterar(@RequestBody Disciplina disciplina) {
            if (Objects.isNull(disciplina.getId())) {
                throw new RuntimeException("id não preenchido");
            }
            return ResponseEntity.ok(disciplinaService.alterar(disciplina));
        }

        @GetMapping("/like/{nome}")
        public ResponseEntity<List<Disciplina>> listarPorLike(@PathVariable String nome){
            return ResponseEntity.ok(disciplinaService.buscarDisciplinaLike(nome));
        }
}
