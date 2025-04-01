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

    // Método para obter todas as fotos
    public List<FotoPessoa> findAll() {
        return fotoPessoaRepository.findAll();
    }

    // Método para encontrar uma foto pelo ID
    public FotoPessoa findById(Integer id) {
        return fotoPessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FotoPessoa não encontrada com id: " + id));
    }

    // Método para encontrar foto pelo FP Hash
    public FotoPessoa findByFpHash(String fpHash) {
        return fotoPessoaRepository.findByFpHash(fpHash);
    }

    // Método para encontrar foto pela PessoaId
    public FotoPessoa findByPessoaId(Integer pessoaId) {
        return fotoPessoaRepository.findByPessoa_PesId(pessoaId);
    }

    // Método para salvar uma nova foto
    public FotoPessoa save(FotoPessoa fotoPessoa) {
        return fotoPessoaRepository.save(fotoPessoa);
    }

    // Método para excluir uma foto pelo ID
    public void deleteById(Integer id) {
        fotoPessoaRepository.deleteById(id);
    }
}
