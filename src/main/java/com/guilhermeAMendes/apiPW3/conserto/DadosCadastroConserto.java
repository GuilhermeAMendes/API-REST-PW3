package com.guilhermeAMendes.apiPW3.conserto;

import com.guilhermeAMendes.apiPW3.mecanico.DadosCadastroMecanico;
import com.guilhermeAMendes.apiPW3.veiculo.DadosCadastroVeiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroConserto(
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String dataEntrada,
        @NotBlank
        @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
        String dataSaida,
        @NotNull
        @Valid
        DadosCadastroMecanico mecanico,
        @NotNull
        @Valid
        DadosCadastroVeiculo veiculo) {
}