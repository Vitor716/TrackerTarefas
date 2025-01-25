package org.example.trackerdeatividade.service;

import org.example.trackerdeatividade.dto.entrada.DadosAtualizarTarefa;
import org.example.trackerdeatividade.dto.entrada.DadosCadastroTarefa;
import org.example.trackerdeatividade.dto.saida.DadosTarefa;
import org.example.trackerdeatividade.model.Status;
import org.example.trackerdeatividade.model.Tarefa;
import org.example.trackerdeatividade.repository.TarefaRepository;
import org.example.trackerdeatividade.util.TarefaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private TarefaValidator validator;

    public void cadastrar(DadosCadastroTarefa tarefa) {
        validator.validarCadastro(tarefa);
        repository.save(new Tarefa(tarefa));
    }

    public List<DadosTarefa> buscarPorTitulo(String titulo) {
        return repository.findByTitulo(titulo);
    }

    public List<DadosTarefa> buscarPorStatus(String status) {
        return repository.findByStatus(status);
    }

    public Optional<DadosTarefa> buscarPorId(Long id) {
        return repository.findById(id).map(DadosTarefa::new);
    }

    public void atualizar(DadosAtualizarTarefa tarefa) {
        Tarefa dados = buscar(tarefa.id());
        validator.validarAlteracoes(tarefa, dados);

        repository.save(dados);
    }

    public void pendenciar(Long id){
        Tarefa tarefa = buscar(id);
        tarefa.setStatus(Status.PENDENTE);
        repository.save(tarefa);
    }

    public void concluir(Long id) {
        Tarefa tarefa = buscar(id);
        tarefa.setStatus(Status.CONCLUIDO);
        repository.save(tarefa);
    }

    public void andamento(Long id) {
        Tarefa tarefa = buscar(id);
        tarefa.setStatus(Status.EM_ANDAMENTO);
        repository.save(tarefa);
    }

    public void inativar(Long id) {
        Tarefa tarefa = buscar(id);
        tarefa.setAtivo(false);
        repository.save(tarefa);
    }

    public List<DadosTarefa> buscarTodas() {
        return repository.findAll().stream().map(DadosTarefa::new).collect(Collectors.toList());
    }

    public List<DadosTarefa> buscarPorDataInicio(LocalDate dataInicio) {
        return repository.findByDataInicio(dataInicio);
    }

    public Tarefa buscar(Long id) {
        return repository.getReferenceById(id);
    }
}
