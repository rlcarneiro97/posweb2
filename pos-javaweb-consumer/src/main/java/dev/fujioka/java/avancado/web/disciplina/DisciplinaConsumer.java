package dev.fujioka.java.avancado.web.disciplina;

import dev.fujioka.java.avancado.web.model.Disciplina;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class DisciplinaConsumer {

    @JmsListener(destination = "disciplina_queue")
    public void receiveMessage(Disciplina disciplina) {
        System.out.println("Mensagem da fila:" + disciplina.getCargaHoraria());
    }
}
