package com.joaocarlos.seplag.Service;

import com.joaocarlos.seplag.entities.Lotacao;
import com.joaocarlos.seplag.repositories.LotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LotacaoService {
    @Autowired
    private LotacaoRepository lotacaoRepository;

    public List<Lotacao> findAll() {
        return lotacaoRepository.findAll();
    }

    public Optional<Lotacao> findById(Long id) {
        return lotacaoRepository.findById(id);
    }

    public Lotacao save(Lotacao lotacao) {
        return lotacaoRepository.save(lotacao);
    }

    public void deleteById(Long id) {
        lotacaoRepository.deleteById(id);
    }
}