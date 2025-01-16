package org.example.trackerdeatividade.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.trackerdeatividade.dto.entrada.DadosAtualizarTarefa;
import org.example.trackerdeatividade.dto.entrada.DadosCadastroTarefa;
import org.example.trackerdeatividade.dto.saida.DadosTarefa;
import org.example.trackerdeatividade.model.Status;
import org.example.trackerdeatividade.model.Tarefa;
import org.example.trackerdeatividade.repository.TarefaRepository;
import org.example.trackerdeatividade.util.TarefaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<DadosTarefa> buscarTarefasPorTitulo(String titulo) {
        return repository.findByTitulo(titulo);
    }

    public List<DadosTarefa> buscarTarefasPorStatus(String status) {
        return repository.findByStatus(status);
    }

    public Optional<DadosTarefa> buscarTarefaPorId(Long id) {
        return repository.findById(id).map(DadosTarefa::new);
    }

    public void atualizarTarefa(DadosAtualizarTarefa tarefa) {
        Tarefa dados = buscarTarefa(tarefa.id());
        validator.validarAlteracoes(tarefa, dados);

        repository.save(dados);
    }

    public void concluirTarefa(Long id) {
        Tarefa tarefa = buscarTarefa(id);
        tarefa.setStatus(Status.CONCLUIDO);

        repository.save(tarefa);
    }

    public void inativarTarefa(Long id) {
        Tarefa tarefa = buscarTarefa(id);
        tarefa.setAtivo(false);

        repository.save(tarefa);
    }

    public Tarefa buscarTarefa(Long id) {
        return repository.getReferenceById(id);
    }
}
