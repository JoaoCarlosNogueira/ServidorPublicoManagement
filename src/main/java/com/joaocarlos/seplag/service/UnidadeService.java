package com.joaocarlos.seplag.service;

import com.joaocarlos.seplag.entities.Unidade;
import com.joaocarlos.seplag.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public Page<Unidade> findAll(Pageable pageable) {
        return unidadeRepository.findAll(pageable);
    }

    public Optional<Unidade> findById(Integer id) {
        return unidadeRepository.findById(id);
    }

    public Unidade save(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    public void deleteById(Integer id) {
        unidadeRepository.deleteById(id);
    }
}