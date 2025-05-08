package com.guilhermeAMendes.apiPW3.controller;

import com.guilhermeAMendes.apiPW3.conserto.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public Page<DadosDetalhadosConserto> listarTodos(@PageableDefault(
            size = 10,
            page = 0,
            sort = {"mecanico.nome"},
            direction = Sort.Direction.DESC
    ) Pageable pageable) {
        return repostory.findAll(pageable).map(DadosDetalhadosConserto::new);
    }

    @GetMapping("algunsdados")
    public List<DadosListagemConserto> listarAlgunsDados() {
        return repostory.findAll().stream().map(DadosListagemConserto::new).toList();
    }
}
