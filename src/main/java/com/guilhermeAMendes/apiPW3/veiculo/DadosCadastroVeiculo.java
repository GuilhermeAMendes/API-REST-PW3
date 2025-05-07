package com.guilhermeAMendes.apiPW3.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroVeiculo(@NotBlank String marca, @NotBlank String modelo,
                                   @Pattern(regexp = "\\d{4}") String ano) {
}
