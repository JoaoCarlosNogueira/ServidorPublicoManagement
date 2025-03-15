package com.joaocarlos.seplag.Service;

import com.joaocarlos.seplag.entities.UnidadeEndereco;
import com.joaocarlos.seplag.repositories.UnidadeEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeEnderecoService {
    @Autowired
    private UnidadeEnderecoRepository unidadeEnderecoRepository;

    public List<UnidadeEndereco> findAll() {
        return unidadeEnderecoRepository.findAll();
    }

    public UnidadeEndereco save(UnidadeEndereco unidadeEndereco) {
        return unidadeEnderecoRepository.save(unidadeEndereco);
    }
}
