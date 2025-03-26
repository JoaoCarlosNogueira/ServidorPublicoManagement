package com.joaocarlos.seplag.controller;

import com.joaocarlos.seplag.service.LotacaoService;
import com.joaocarlos.seplag.entities.Lotacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/lotacao")
public class LotacaoController {
    @Autowired
    private LotacaoService lotacaoService;

    @GetMapping
    public ResponseEntity<List<Lotacao>> listarTodos() {
        return ResponseEntity.ok(lotacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lotacao> buscarPorId(@PathVariable Integer id) {
        return lotacaoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Lotacao> criar(@RequestBody Lotacao lotacao) {
        Lotacao novaLotacao = lotacaoService.save(lotacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaLotacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lotacao> atualizar(@PathVariable Integer id, @RequestBody Lotacao lotacao) {
        return lotacaoService.findById(id)
                .map(existente -> {
                    lotacao.setLotId(id); // Mantém o ID
                    Lotacao atualizado = lotacaoService.save(lotacao);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (lotacaoService.findById(id).isPresent()) {
            lotacaoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
