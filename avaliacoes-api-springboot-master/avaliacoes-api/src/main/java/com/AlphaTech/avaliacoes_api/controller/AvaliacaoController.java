package com.AlphaTech.avaliacoes_api.controller;

import com.AlphaTech.avaliacoes_api.model.Avaliacao;
import com.AlphaTech.avaliacoes_api.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public List<Avaliacao> getAll() {
        return avaliacaoService.getAll();
    }

    @PostMapping
    public Avaliacao create(@RequestBody Avaliacao avaliacao) {
        return avaliacaoService.save(avaliacao);
    }

    @GetMapping("/{id}")
    public Avaliacao getById(@PathVariable Long id) {
        return avaliacaoService.getById(id);
    }
}
