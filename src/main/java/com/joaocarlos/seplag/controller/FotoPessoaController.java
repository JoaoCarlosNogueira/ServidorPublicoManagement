package com.joaocarlos.seplag.controller;

import com.joaocarlos.seplag.entities.FotoPessoa;
import com.joaocarlos.seplag.entities.Pessoa;
import com.joaocarlos.seplag.service.FotoPessoaService;
import com.joaocarlos.seplag.service.MinioService;
import com.joaocarlos.seplag.service.PessoaService;
import io.minio.MinioClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date;

@RestController
@RequestMapping("/foto-pessoa")
public class FotoPessoaController {

    private final MinioService minioService;
    private final FotoPessoaService fotoPessoaService;
    private final PessoaService pessoaService;
    private final MinioClient minioClient;

    public FotoPessoaController(MinioService minioService, FotoPessoaService fotoPessoaService,PessoaService pessoaService ,MinioClient minioClient) {
        this.minioService = minioService;
        this.fotoPessoaService = fotoPessoaService;
        this.minioClient = minioClient;
        this.pessoaService = pessoaService;
    }

    @Operation(summary = "Upload de foto", description = "Envia uma foto e vincula a uma pessoa pelo ID")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFoto(
            @RequestParam("pesId") @Parameter(description = "ID da Pessoa", required = true) Integer pessoaId,
            @RequestParam("file") MultipartFile file) {
        try {
            Pessoa pessoa = pessoaService.findById(pessoaId)
                    .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com ID: " + pessoaId));

            String fileName = minioService.uploadFile(file);

            FotoPessoa foto = new FotoPessoa();
            foto.setPessoa(pessoa);
            foto.setFpData(new Date());
            foto.setFpBucket("servidores");
            foto.setFpHash(fileName);

            fotoPessoaService.save(foto);
            return ResponseEntity.ok("Foto enviada com sucesso! Hash: " + fileName);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro ao enviar foto: " + e.getMessage());
        }
    }

    @Operation(summary = "Recuperar foto", description = "Recupera a foto de uma pessoa pelo ID")
    @GetMapping("/buscar/{pessoaId}")
    public ResponseEntity<String> getFoto(@PathVariable Integer pessoaId) {
        try {
            FotoPessoa foto = fotoPessoaService.findByPessoaId(pessoaId);

            if (foto == null) {
                return ResponseEntity.notFound().build();
            }

            String fileName = foto.getFpHash();

            String imageUrl = minioService.generateFileUrl(fileName);

            return ResponseEntity.ok(imageUrl);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar a foto.");
        }
    }
}
