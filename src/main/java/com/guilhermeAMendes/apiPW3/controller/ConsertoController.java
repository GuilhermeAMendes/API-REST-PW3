package com.guilhermeAMendes.apiPW3.controller;

import com.guilhermeAMendes.apiPW3.conserto.Conserto;
import com.guilhermeAMendes.apiPW3.conserto.ConsertoRepostory;
import com.guilhermeAMendes.apiPW3.conserto.DadosCadastroConserto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepostory repostory;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroConserto dados) {
        Conserto conserto = new Conserto(dados);
        repostory.save(conserto);
    }
}
