package com.joaocarlos.seplag.Controller;

import com.joaocarlos.seplag.Service.ServidorEfetivoService;
import com.joaocarlos.seplag.entities.ServidorEfetivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/servidor")
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        servidorEfetivoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
