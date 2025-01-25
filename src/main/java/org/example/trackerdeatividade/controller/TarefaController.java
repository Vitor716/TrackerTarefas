package org.example.trackerdeatividade.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.example.trackerdeatividade.dto.entrada.DadosAtualizarTarefa;
import org.example.trackerdeatividade.dto.entrada.DadosCadastroTarefa;
import org.example.trackerdeatividade.dto.saida.DadosTarefa;
import org.example.trackerdeatividade.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping()
    public List<DadosTarefa> listar() {
        return service.buscarTodas();
    }

    @GetMapping("/dataInicio/{dataInicio}")
    public List<DadosTarefa> buscarPorDataInicio(@PathVariable LocalDate dataInicio) {
        return service.buscarPorDataInicio(dataInicio);
    }

    @GetMapping("/titulo/{titulo}")
    public List<DadosTarefa> buscarTarefasPorTitulo(@PathVariable String titulo) {
        return service.buscarPorTitulo(titulo);
    }

    @GetMapping("/id/{id}")
    public Optional<DadosTarefa> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/status/{status}")
    public List<DadosTarefa> buscarPorStatus(@PathVariable String status) {
        return service.buscarPorStatus(status);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarTarefa tarefa) {
        service.atualizar(tarefa);
    }

    @PutMapping("/concluir/{id}")
    @Transactional
    public void concluir(@PathVariable Long id){
        service.concluir(id);
    }

    @PutMapping("/pendenciar/{id}")
    @Transactional
    public void pendenciar(@PathVariable Long id){
        service.pendenciar(id);
    }

    @PutMapping("/andamento/{id}")
    @Transactional
    public void andamento(@PathVariable Long id){
        service.andamento(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void inativar(@PathVariable Long id){
        service.inativar(id);
    }
}
