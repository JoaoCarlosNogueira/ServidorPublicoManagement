package com.joaocarlos.seplag.Service;

import com.joaocarlos.seplag.entities.ServidorEfetivo;
import com.joaocarlos.seplag.repositories.ServidorEfetivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServidorEfetivoService {
    @Autowired
    private ServidorEfetivoRepository servidorEfetivoRepository;

    public Optional<ServidorEfetivo> findById(Integer id) {
        return servidorEfetivoRepository.findById(id);
    }

    public ServidorEfetivo save(ServidorEfetivo servidorEfetivo) {
        return servidorEfetivoRepository.save(servidorEfetivo);
    }

    public void deleteById(Integer id) {
        servidorEfetivoRepository.deleteById(id);
    }
}