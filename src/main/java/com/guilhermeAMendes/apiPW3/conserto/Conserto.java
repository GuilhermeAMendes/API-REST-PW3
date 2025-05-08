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
    private boolean ativo;

    public Conserto(DadosCadastroConserto dadosCadastroConserto) {
        this.ativo = true;
        this.dataEntrada = dadosCadastroConserto.dataEntrada();
        this.dataSaida = dadosCadastroConserto.dataSaida();
        this.mecanico = new Mecanico(dadosCadastroConserto.mecanico());
        this.veiculo = new Veiculo(dadosCadastroConserto.veiculo());
    }

    public void atualizaDados(DadosAtualizacao dados){
        if(dados.dataSaida() != null)
            dataSaida = dados.dataSaida();
        if(dados.mecanico() != null)
            mecanico.atualizaDados(dados.mecanico());
    }

    public void excluir(){
        this.ativo = false;
    }

}
