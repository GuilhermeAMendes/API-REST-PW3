package com.guilhermeAMendes.apiPW3.conserto;

public record DadosListagemConserto(
        Long id,
        String dataEntrada,
        String dataSaida,
        String nome,
        String marca,
        String modelo) {
    public DadosListagemConserto(Conserto conserto) {
        this(   conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo()
        );
    }
}