package com.joaocarlos.seplag.Service;

import com.joaocarlos.seplag.entities.ServidorTemporario;
import com.joaocarlos.seplag.repositories.ServidorTemporarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServidorTemporarioService {
    @Autowired
    private ServidorTemporarioRepository servidorTemporarioRepository;

    public Optional<ServidorTemporario> findById(Integer id) {
        return servidorTemporarioRepository.findById(id);
    }

    public ServidorTemporario save(ServidorTemporario servidorTemporario) {
        return servidorTemporarioRepository.save(servidorTemporario);
    }

    public void deleteById(Integer id) {
        servidorTemporarioRepository.deleteById(id);
    }
}
