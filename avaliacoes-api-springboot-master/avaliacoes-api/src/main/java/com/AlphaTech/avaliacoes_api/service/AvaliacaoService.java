package com.AlphaTech.avaliacoes_api.service;

import com.AlphaTech.avaliacoes_api.model.Avaliacao;
import com.AlphaTech.avaliacoes_api.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> getAll() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao save(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao getById(Long id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }
}