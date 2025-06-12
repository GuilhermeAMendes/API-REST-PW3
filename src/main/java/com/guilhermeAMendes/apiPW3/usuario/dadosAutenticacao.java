package com.guilhermeAMendes.apiPW3.usuario;

import jakarta.validation.constraints.NotBlank;

public record dadosAutenticacao(

        @NotBlank
        String login,

        @NotBlank
        String senha) {

}