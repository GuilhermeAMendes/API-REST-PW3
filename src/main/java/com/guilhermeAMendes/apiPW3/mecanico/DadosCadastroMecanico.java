package com.guilhermeAMendes.apiPW3.mecanico;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroMecanico(@NotBlank String nome, @NotBlank int anosExperiencia) {
}
