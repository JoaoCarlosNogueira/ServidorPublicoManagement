package com.joaocarlos.seplag.controller;

import com.joaocarlos.seplag.dto.UnidadeDTO;
import com.joaocarlos.seplag.service.UnidadeService;
import com.joaocarlos.seplag.entities.Unidade;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/unidade")
public class UnidadeController {
    @Autowired
    private UnidadeService unidadeService;

    @GetMapping
    public ResponseEntity<Page<Unidade>> listarTodos(@ParameterObject @PageableDefault(sort = "unidNome", direction = Sort.Direction.ASC)Pageable pageable) {
        return ResponseEntity.ok(unidadeService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscarPorId(@PathVariable Integer id) {
        return unidadeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Unidade> criar(@RequestBody UnidadeDTO unidadeDTO) {
        Unidade unidade = new Unidade();
        unidade.setUnidNome(unidadeDTO.getUnidNome());
        unidade.setUnidSigla(unidadeDTO.getUnidSigla());
        unidadeService.save(unidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(unidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidade> atualizar(@PathVariable Integer id, @RequestBody Unidade unidade) {
        return unidadeService.findById(id)
                .map(existente -> {
                    unidade.setUnidId(id);
                    Unidade atualizado = unidadeService.save(unidade);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (unidadeService.findById(id).isPresent()) {
            unidadeService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
