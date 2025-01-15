package org.example.trackerdeatividade.util;

import org.example.trackerdeatividade.dto.entrada.DadosAtualizarTarefa;
import org.example.trackerdeatividade.model.Tarefa;
import org.springframework.stereotype.Component;

@Component
public class TarefaValidator {

    public void validaAlteracoes(DadosAtualizarTarefa tarefa, Tarefa dados) {
        if(tarefa.descricao() != null) {
            dados.setDescricao(tarefa.descricao());
        }

        if(tarefa.dataConclusao() != null) {
            dados.setDataConclusao(tarefa.dataConclusao());
        }
    }
}
