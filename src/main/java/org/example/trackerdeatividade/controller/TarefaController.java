package org.example.trackerdeatividade.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.trackerdeatividade.dto.entrada.DadosAtualizarTarefa;
import org.example.trackerdeatividade.dto.entrada.DadosCadastroTarefa;
import org.example.trackerdeatividade.dto.saida.DadosTarefa;
import org.example.trackerdeatividade.model.Tarefa;
import org.example.trackerdeatividade.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTarefa dados) {
        service.cadastrar(dados);
    }

    @GetMapping("/titulo/{titulo}")
    public List<DadosTarefa> buscarTarefasPorTitulo(@PathVariable String titulo) {
        return service.buscarTarefasPorTitulo(titulo);
    }

    @GetMapping("/id/{id}")
    public Optional<DadosTarefa> buscarTarefaPorId(@PathVariable Long id) {
        return service.buscarTarefaPorId(id);
    }

    @GetMapping("/status/{status}")
    public List<DadosTarefa> buscarTarefasPorStatus(@PathVariable String status) {
        return service.buscarTarefasPorStatus(status);
    }

    @PutMapping
    @Transactional
    public void atualizarTarefa(@RequestBody @Valid DadosAtualizarTarefa tarefa) {
        service.atualizarTarefa(tarefa);
    }

    @PutMapping("/{id}")
    @Transactional
    public void concluirTarefa(@PathVariable Long id){
        service.concluirTarefa(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void inativarTarefa(@PathVariable Long id){
        service.inativarTarefa(id);
    }
}
