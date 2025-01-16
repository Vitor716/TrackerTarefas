package org.example.trackerdeatividade.dto.entrada;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosAtualizarTarefa(
        @NotNull
        Long id,

        String descricao,

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dataInicio,

        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dataTermino,

        Boolean ativo
) {
}
