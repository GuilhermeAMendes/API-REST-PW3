package com.guilhermeAMendes.apiPW3.controller;

import com.guilhermeAMendes.apiPW3.conserto.Conserto;
import com.guilhermeAMendes.apiPW3.conserto.ConsertoRepostory;
import com.guilhermeAMendes.apiPW3.conserto.DadosCadastroConserto;
import com.guilhermeAMendes.apiPW3.conserto.DadosListagemConserto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<Conserto> listarTodosOsConsertos() {
        return repostory.findAll();
    }

    @GetMapping("algunsdados")
    public List<DadosListagemConserto> listarAlgunsDados() {
        return repostory.findAll().stream().map(DadosListagemConserto::new).toList();
    }
}
