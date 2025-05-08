package com.guilhermeAMendes.apiPW3.veiculo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private String ano;
    private String cor;

    public Veiculo(DadosCadastroVeiculo dadosCadastroVeiculo) {
        this.marca = dadosCadastroVeiculo.marca();
        this.modelo = dadosCadastroVeiculo.modelo();
        this.ano = dadosCadastroVeiculo.ano();
        this.cor = dadosCadastroVeiculo.cor();
    }
}