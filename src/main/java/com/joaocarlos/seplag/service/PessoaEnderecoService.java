package com.joaocarlos.seplag.service;

import com.joaocarlos.seplag.entities.PessoaEndereco;
import com.joaocarlos.seplag.repositories.PessoaEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaEnderecoService {
    @Autowired
    private PessoaEnderecoRepository pessoaEnderecoRepository;

    public List<PessoaEndereco> findAll() {
        return pessoaEnderecoRepository.findAll();
    }

    public PessoaEndereco save(PessoaEndereco pessoaEndereco) {
        return pessoaEnderecoRepository.save(pessoaEndereco);
    }
}