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

    private LocalDate dataConclusao;

    public Tarefa(DadosCadastroTarefa tarefa) {
        this.titulo = tarefa.titulo();
        this.descricao = tarefa.descricao();
        this.status = tarefa.status();
        this.dataConclusao = tarefa.dataConclusao();
    }
}
