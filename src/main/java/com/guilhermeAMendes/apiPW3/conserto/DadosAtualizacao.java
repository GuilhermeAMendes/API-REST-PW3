package com.guilhermeAMendes.apiPW3.conserto;

import com.guilhermeAMendes.apiPW3.mecanico.DadosAtualizacaoMecanico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacao(@NotNull Long id,
                               @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
                               String dataSaida,
                               @Valid DadosAtualizacaoMecanico mecanico) {
}
