package com.joaocarlos.seplag.controller;

import com.joaocarlos.seplag.service.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Autenticação", description = "Endpoints para autenticação e autorização")
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {

        if ("admin".equals(username) && "1234".equals(password)) {
            String token = tokenService.gerarToken();
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Credenciais inválidas");
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> renovarToken(@RequestParam String token) {
        tokenService.renovarToken(token);
        return ResponseEntity.ok("Token renovado");
    }
}
