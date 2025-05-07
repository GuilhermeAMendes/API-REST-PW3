package com.guilhermeAMendes.apiPW3.controller;

import com.guilhermeAMendes.apiPW3.conserto.DadosCadastroConserto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consertos")
public class ConsertoController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroConserto dados) {
        System.out.println(dados);
    }
}
