package com.joaocarlos.seplag.service;

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
    
    public FotoPessoa findById(Integer id) {
        return fotoPessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FotoPessoa não encontrada com id: " + id));
    }

    public FotoPessoa findByFpHash(String fpHash) {
        return fotoPessoaRepository.findByFpHash(fpHash);
    }

    public FotoPessoa findByPessoaId(Integer pessoaId) {
        return fotoPessoaRepository.findByPessoa_PesId(pessoaId);
    }

    public FotoPessoa save(FotoPessoa fotoPessoa) {
        return fotoPessoaRepository.save(fotoPessoa);
    }

    public void deleteById(Integer id) {
        fotoPessoaRepository.deleteById(id);
    }
}
