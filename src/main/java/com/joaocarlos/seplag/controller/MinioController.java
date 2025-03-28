package com.joaocarlos.seplag.controller;

import com.joaocarlos.seplag.service.MinioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/imagens")
public class MinioController {

    private final MinioService minioService;

    public MinioController(MinioService minioService) {
        this.minioService = minioService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImagem(@RequestParam("file") MultipartFile file) {
        try {
            String objectName = minioService.uploadImagem(file);
            return ResponseEntity.ok("Imagem enviada com sucesso: " + objectName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao enviar imagem: " + e.getMessage());
        }
    }

    @GetMapping("/link")
    public ResponseEntity<String> gerarLink(@RequestParam String nome) {
        try {
            String link = minioService.gerarLinkTemporario(nome);
            return ResponseEntity.ok(link);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao gerar link: " + e.getMessage());
        }
    }
}
