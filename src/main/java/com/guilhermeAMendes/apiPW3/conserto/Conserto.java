package com.guilhermeAMendes.apiPW3.conserto;

import com.guilhermeAMendes.apiPW3.mecanico.Mecanico;
import com.guilhermeAMendes.apiPW3.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "consertos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataEntrada;
    private String dataSaida;
    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;

    public Conserto(DadosCadastroConserto dadosCadastroConserto) {
        this.dataEntrada = dadosCadastroConserto.dataEntrada();
        this.dataSaida = dadosCadastroConserto.dataSaida();
        this.mecanico = new Mecanico(dadosCadastroConserto.mecanico());
        this.veiculo = new Veiculo(dadosCadastroConserto.veiculo());
    }

}
