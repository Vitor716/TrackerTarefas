package org.example.trackerdeatividade.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.trackerdeatividade.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tarefa")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTarefa dados) {
        service.save(dados);
    }

    
}
