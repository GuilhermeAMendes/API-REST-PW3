package com.guilhermeAMendes.apiPW3.controller;

import com.guilhermeAMendes.apiPW3.conserto.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Page<DadosDetalhadosConserto>> listarTodos(@PageableDefault(
            size = 10,
            page = 0,
            sort = {"mecanico.nome"},
            direction = Sort.Direction.DESC
    ) Pageable pageable) {
        return ResponseEntity.ok(repostory.findAll(pageable).map(DadosDetalhadosConserto::new));
    }

    @GetMapping("algunsdados")
    public ResponseEntity<List<DadosListagemConserto>> listarAlgunsDados() {
        return ResponseEntity.ok(repostory.findAllByAtivoTrue().stream().map(DadosListagemConserto::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhadosConserto> buscarConsertoById(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repostory.findById(id);
        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DadosDetalhadosConserto(conserto));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizacao dados) {
        Conserto conserto = repostory.getReferenceById(dados.id());
        conserto.atualizaDados(dados);
        return ResponseEntity.ok(new DadosDetalhadosConserto(conserto));
    }
}
