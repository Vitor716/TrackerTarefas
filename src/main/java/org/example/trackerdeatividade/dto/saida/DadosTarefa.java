package org.example.trackerdeatividade.dto.saida;

import org.example.trackerdeatividade.dto.entrada.DadosCadastroTarefa;
import org.example.trackerdeatividade.model.Status;
import org.example.trackerdeatividade.model.Tarefa;

import java.time.LocalDate;

public record DadosTarefa(
        Long id,

        String titulo,

        String descricao,

        Status status,

        LocalDate dataConclusao
) {
    public DadosTarefa (Tarefa tarefa) {
        this(tarefa.getId(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getStatus(), tarefa.getDataConclusao());
    }
}
