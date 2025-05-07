package com.guilhermeAMendes.apiPW3.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private int anosExperiencia;

    public Mecanico(DadosCadastroMecanico dadosCadastro) {
        this.nome = dadosCadastro.nome();
        this.anosExperiencia = dadosCadastro.anosExperiencia();
    }
}
