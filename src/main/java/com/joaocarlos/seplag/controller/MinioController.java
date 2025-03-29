package com.joaocarlos.seplag.controller;

import com.joaocarlos.seplag.service.MinioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
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

    @Operation(summary = "Faz upload de uma imagem para o MinIO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Imagem enviada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao enviar imagem")
    })
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImagem(@RequestParam("file") MultipartFile file) {
        try {
            String objectName = minioService.uploadImagem(file);
            return ResponseEntity.ok("Imagem enviada com sucesso: " + objectName);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao enviar imagem: " + e.getMessage());
        }
    }

    @Operation(summary = "Gera o link de recuperação da imagem enviada ao MinIO")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Imagem recuperada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro recuperar imagem")
    })
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
