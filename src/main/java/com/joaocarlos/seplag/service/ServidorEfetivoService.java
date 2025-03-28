package com.joaocarlos.seplag.service;

import com.joaocarlos.seplag.dto.EnderecoDTO;
import com.joaocarlos.seplag.dto.ServidorDTO;
import com.joaocarlos.seplag.entities.ServidorEfetivo;
import com.joaocarlos.seplag.repositories.ServidorEfetivoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
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

    public int calcularIdade(Date dataNascimento) {
        if (dataNascimento == null) return 0;
        LocalDate nascimento = dataNascimento.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        return Period.between(nascimento, LocalDate.now()).getYears();
    }

    public List<ServidorDTO> getServidoresByUnidade(Integer unidId) {
        List<ServidorDTO> servidores = repository.findServidoresByUnidade(unidId);
        servidores.forEach(servidor ->{
            servidor.setIdade(calcularIdade(servidor.getDataNascimento()));
        });
        return servidores;
    }

    public Page<EnderecoDTO> getEnderecoByNome(String nomeParte, Pageable pageable) {
        return repository.findEnderecoByNome(nomeParte,pageable);
    }

}