package dev.fujioka.java.avancado.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class WebApplication{

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
