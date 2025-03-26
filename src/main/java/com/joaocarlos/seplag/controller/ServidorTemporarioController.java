package com.joaocarlos.seplag.controller;

import com.joaocarlos.seplag.service.ServidorTemporarioService;
import com.joaocarlos.seplag.entities.ServidorTemporario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/servidortemporario")
public class ServidorTemporarioController {
    @Autowired
    private ServidorTemporarioService servidorTemporarioService;

    @GetMapping("/{id}")
    public ResponseEntity<ServidorTemporario> buscarPorId(@PathVariable Integer id) {
        Optional<ServidorTemporario> servidor = servidorTemporarioService.findById(id);
        return servidor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ServidorTemporario>> listarTodos() {
        return ResponseEntity.ok(servidorTemporarioService.findAll());
    }

    @PostMapping
    public ResponseEntity<ServidorTemporario> criar(@RequestBody ServidorTemporario servidorTemporario) {
        ServidorTemporario novoServidor = servidorTemporarioService.save(servidorTemporario);
        return ResponseEntity.ok(novoServidor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServidorTemporario> atualizar(@PathVariable Integer id, @RequestBody ServidorTemporario servidorAtualizado) {
        ServidorTemporario atualizado = servidorTemporarioService.update(id, servidorAtualizado);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        servidorTemporarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

