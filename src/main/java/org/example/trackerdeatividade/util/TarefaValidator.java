package org.example.trackerdeatividade.util;

import org.example.trackerdeatividade.dto.entrada.DadosAtualizarTarefa;
import org.example.trackerdeatividade.dto.entrada.DadosCadastroTarefa;
import org.example.trackerdeatividade.exception.DataConclusaoInvalidaException;
import org.example.trackerdeatividade.exception.TituloInvalidoException;
import org.example.trackerdeatividade.model.Tarefa;
import org.springframework.stereotype.Component;

@Component
public class TarefaValidator {

    public void validarAlteracoes(DadosAtualizarTarefa tarefa, Tarefa dados) {
        if(tarefa.descricao() != null) {
            dados.setDescricao(tarefa.descricao());
        }

        if(tarefa.dataInicio() != null) {
            dados.setDataInicio(tarefa.dataInicio());
        }

        if(tarefa.dataTermino() != null) {
            dados.setDataTermino(tarefa.dataTermino());
        }

        if(tarefa.ativo() != null) {
            dados.setAtivo(tarefa.ativo());
        }
    }

    public void validarCadastro(DadosCadastroTarefa tarefa) {
        if(tarefa.titulo() == null || tarefa.titulo().isBlank()) {
            throw new TituloInvalidoException("O título da tarefa não pode ser vazio.");
        }

        if (tarefa.dataTermino() != null && tarefa.dataTermino().isBefore(tarefa.dataInicio())) {
            throw new DataConclusaoInvalidaException("A data de termino não pode ser no passado.");
        }
    }
}
