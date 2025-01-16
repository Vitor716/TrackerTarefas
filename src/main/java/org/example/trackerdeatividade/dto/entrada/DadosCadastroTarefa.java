package org.example.trackerdeatividade.dto.entrada;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroTarefa(
        String titulo,

        String descricao,

        @NotNull
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dataInicio,

        @NotNull
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dataTermino
) {
}
