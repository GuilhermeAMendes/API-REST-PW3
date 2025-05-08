package com.guilhermeAMendes.apiPW3.conserto;

import com.guilhermeAMendes.apiPW3.mecanico.Mecanico;
import com.guilhermeAMendes.apiPW3.veiculo.Veiculo;

public record DadosDetalhadosConserto(Long id,
                                      String dataentrada,
                                      String datasaida,
                                      Mecanico mecanico,
                                      Veiculo veiculo) {
    public DadosDetalhadosConserto(Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanico(),
                conserto.getVeiculo());
    }
}
