package com.joaocarlos.seplag.service;

import com.joaocarlos.seplag.entities.ServidorTemporario;
import com.joaocarlos.seplag.repositories.ServidorTemporarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ServidorTemporarioService {
    @Autowired
    private ServidorTemporarioRepository servidorTemporarioRepository;
    @Autowired
    private PessoaService pessoaService;

    public Page<ServidorTemporario> findAll(Pageable pageable) {
        return servidorTemporarioRepository.findAll(pageable);
    }

    public Optional<ServidorTemporario> findById(Integer id) {
        return servidorTemporarioRepository.findById(id);
    }

    public ServidorTemporario save(ServidorTemporario servidorTemporario) {
        return servidorTemporarioRepository.save(servidorTemporario);
    }

    public ServidorTemporario update(Integer id, ServidorTemporario servidorAtualizado) {
        return servidorTemporarioRepository.findById(id).map(servidor -> {
            servidor.setStDataAdmissao(servidorAtualizado.getStDataAdmissao());
            servidor.setStDataDemissao(servidorAtualizado.getStDataDemissao());
            return servidorTemporarioRepository.save(servidor);
        }).orElseThrow(() -> new RuntimeException("Servidor Temporário não encontrado com ID: " + id));
    }

    public void deleteById(Integer id) {
        servidorTemporarioRepository.deleteById(id);
    }
}
