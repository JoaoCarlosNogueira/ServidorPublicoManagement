package com.joaocarlos.seplag.service;

import com.joaocarlos.seplag.entities.Lotacao;
import com.joaocarlos.seplag.repositories.LotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LotacaoService {
    @Autowired
    private LotacaoRepository lotacaoRepository;

    public Page<Lotacao> findAll(Pageable pageable) {
        return lotacaoRepository.findAll(pageable);
    }

    public Optional<Lotacao> findById(Integer id) {
        return lotacaoRepository.findById(id);
    }

    public Lotacao save(Lotacao lotacao) {
        return lotacaoRepository.save(lotacao);
    }

    public void deleteById(Integer id) {
        lotacaoRepository.deleteById(id);
    }
}