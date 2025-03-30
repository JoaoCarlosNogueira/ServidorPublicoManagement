package com.joaocarlos.seplag.controller;

import com.joaocarlos.seplag.dto.EnderecoDTO;
import com.joaocarlos.seplag.service.ServidorEfetivoService;
import com.joaocarlos.seplag.dto.ServidorDTO;
import com.joaocarlos.seplag.entities.ServidorEfetivo;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<ServidorEfetivo>> listarTodos(@ParameterObject @PageableDefault(sort = "pessoa", direction = Sort.Direction.ASC)Pageable pageable) {
        return ResponseEntity.ok(servidorEfetivoService.findAll(pageable));
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
    public Page<ServidorDTO> getServidoresByUnidade(@RequestParam Integer unidId, @ParameterObject @PageableDefault(sort = "pessoa", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.getServidoresByUnidade(unidId,pageable);
    }

    @GetMapping("/endereco")
    public Page<EnderecoDTO> getEnderecoByNome(@RequestParam String nomeServidor, @ParameterObject @PageableDefault(sort = "pessoa", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.getEnderecoByNome(nomeServidor,pageable);
    }

}
