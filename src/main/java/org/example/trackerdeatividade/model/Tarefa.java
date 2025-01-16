package org.example.trackerdeatividade.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.trackerdeatividade.dto.entrada.DadosAtualizarTarefa;
import org.example.trackerdeatividade.dto.entrada.DadosCadastroTarefa;

import java.time.LocalDate;

@Entity(name = "tarefas")
@Table(name = "Tarefas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate dataInicio;

    private LocalDate dataTermino;

    private Boolean ativo;

    public Tarefa(DadosCadastroTarefa tarefa) {
        this.titulo = tarefa.titulo();
        this.status = Status.PENDENTE;
        this.descricao = tarefa.descricao();
        this.dataInicio = tarefa.dataInicio();
        this.dataTermino = tarefa.dataTermino();
        this.ativo = true;
    }
}
