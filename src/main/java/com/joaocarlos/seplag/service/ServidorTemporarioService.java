package com.joaocarlos.seplag.service;

import com.joaocarlos.seplag.entities.ServidorTemporario;
import com.joaocarlos.seplag.repositories.ServidorTemporarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServidorTemporarioService {
    @Autowired
    private ServidorTemporarioRepository servidorTemporarioRepository;

    public List<ServidorTemporario> findAll() {
        return servidorTemporarioRepository.findAll();
    }

    public Optional<ServidorTemporario> findById(Integer id) {
        return servidorTemporarioRepository.findById(id);
    }

    public ServidorTemporario save(ServidorTemporario servidorTemporario) {
        if (servidorTemporario.getPessoa() == null || servidorTemporario.getPessoa().getPesId() == null) {
            throw new IllegalArgumentException("Pessoa e seu ID não podem ser nulos ao salvar Servidor Temporário.");
        }

        servidorTemporario.setPesId(servidorTemporario.getPessoa().getPesId());
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
