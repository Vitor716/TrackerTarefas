package org.example.trackerdeatividade.dto.entrada;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.trackerdeatividade.model.Status;

import java.time.LocalDate;

public record DadosCadastroTarefa(
        @NotBlank
        String titulo,

        String descricao,

        @NotNull
        Status status,

        @NotNull
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate dataConclusao
) {
}
