package com.joaocarlos.seplag.Service;

import com.joaocarlos.seplag.entities.Unidade;
import com.joaocarlos.seplag.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeService {
    @Autowired
    private UnidadeRepository unidadeRepository;

    public List<Unidade> findAll() {
        return unidadeRepository.findAll();
    }

    public Optional<Unidade> findById(Long id) {
        return unidadeRepository.findById(id);
    }

    public Unidade save(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    public void deleteById(Long id) {
        unidadeRepository.deleteById(id);
    }
}