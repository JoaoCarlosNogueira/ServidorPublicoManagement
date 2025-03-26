package com.joaocarlos.seplag.service;

import com.joaocarlos.seplag.entities.Cidade;
import com.joaocarlos.seplag.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    public Optional<Cidade> findById(Integer id) {
        return cidadeRepository.findById(id);
    }

    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public void deleteById(Integer id) {
        cidadeRepository.deleteById(id);
    }
}