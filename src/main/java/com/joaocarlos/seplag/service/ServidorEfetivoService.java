package com.joaocarlos.seplag.service;

import com.joaocarlos.seplag.dto.ServidorDTO;
import com.joaocarlos.seplag.entities.ServidorEfetivo;
import com.joaocarlos.seplag.repositories.ServidorEfetivoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServidorEfetivoService {
    @Autowired
    private ServidorEfetivoRepository servidorEfetivoRepository;

    public List<ServidorEfetivo> findAll() {
        return servidorEfetivoRepository.findAll();
    }

    public Optional<ServidorEfetivo> findById(Integer id) {
        return servidorEfetivoRepository.findById(id);
    }

    public ServidorEfetivo save(ServidorEfetivo servidorEfetivo)
    {
        return servidorEfetivoRepository.save(servidorEfetivo);
    }

    public void deleteById(Integer id) {
        servidorEfetivoRepository.deleteById(id);
    }

    public ServidorEfetivo update(Integer id, ServidorEfetivo servidorEfetivoAtualizado) {
        return servidorEfetivoRepository.findById(id)
                .map(servidor -> {
                    servidor.setSeMatricula(servidorEfetivoAtualizado.getSeMatricula());
                    return servidorEfetivoRepository.save(servidor);
                })
                .orElseThrow(() -> new EntityNotFoundException("Servidor Efetivo não encontrado com ID: " + id));
    }

    private final ServidorEfetivoRepository repository;

    public ServidorEfetivoService(ServidorEfetivoRepository repository) {
        this.repository = repository;
    }

    public List<ServidorDTO> getServidoresByUnidade(Integer unidId) {
        return repository.findServidoresByUnidade(unidId);
    }
}