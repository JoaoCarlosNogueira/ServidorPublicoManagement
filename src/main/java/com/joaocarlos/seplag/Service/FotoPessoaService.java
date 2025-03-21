package com.joaocarlos.seplag.Service;

import com.joaocarlos.seplag.entities.FotoPessoa;
import com.joaocarlos.seplag.repositories.FotoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FotoPessoaService {
    @Autowired
    private FotoPessoaRepository fotoPessoaRepository;

    public List<FotoPessoa> findAll() {
        return fotoPessoaRepository.findAll();
    }

    public Optional<FotoPessoa> findById(Integer id) {
        return fotoPessoaRepository.findById(id);
    }

    public FotoPessoa save(FotoPessoa fotoPessoa) {
        return fotoPessoaRepository.save(fotoPessoa);
    }

    public void deleteById(Integer id) {
        fotoPessoaRepository.deleteById(id);
    }
}
