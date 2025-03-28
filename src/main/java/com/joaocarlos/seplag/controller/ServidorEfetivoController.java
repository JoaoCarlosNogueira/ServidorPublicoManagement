package com.joaocarlos.seplag.controller;

import com.joaocarlos.seplag.dto.EnderecoDTO;
import com.joaocarlos.seplag.service.ServidorEfetivoService;
import com.joaocarlos.seplag.dto.ServidorDTO;
import com.joaocarlos.seplag.entities.ServidorEfetivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/servidorefetivo")
public class ServidorEfetivoController {
    @Autowired
    private ServidorEfetivoService servidorEfetivoService;

    @GetMapping ("/{id}")
    public ResponseEntity<ServidorEfetivo> buscarPorId(@PathVariable Integer id) {
        return servidorEfetivoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ServidorEfetivo>> listarTodos() {
        return ResponseEntity.ok(servidorEfetivoService.findAll());
    }

    @PostMapping
    public ResponseEntity<ServidorEfetivo> criar(@RequestBody ServidorEfetivo servidorEfetivo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servidorEfetivoService.save(servidorEfetivo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServidorEfetivo> atualizar(@PathVariable Integer id, @RequestBody ServidorEfetivo servidorEfetivoAtualizado) {
        ServidorEfetivo atualizado = servidorEfetivoService.update(id, servidorEfetivoAtualizado);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        servidorEfetivoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private final ServidorEfetivoService service;

    public ServidorEfetivoController(ServidorEfetivoService service) {
        this.service = service;
    }

    @GetMapping("/unidade/{unidId}")
    public List<ServidorDTO> getServidoresByUnidade(@PathVariable Integer unidId) {
        return service.getServidoresByUnidade(unidId);
    }

    @GetMapping("/endereco")
    public Page<EnderecoDTO> getEnderecoByNome(@RequestParam String servidor, Pageable pageable) {
        return service.getEnderecoByNome(servidor,pageable);
    }

}
