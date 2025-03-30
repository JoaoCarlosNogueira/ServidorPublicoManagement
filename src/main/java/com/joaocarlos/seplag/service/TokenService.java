package com.joaocarlos.seplag.service;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenService {
    private final Map<String, Instant> tokens = new HashMap<>();

    public String gerarToken() {
        String token = UUID.randomUUID().toString();
        tokens.put(token, Instant.now().plusSeconds(300));
        return token;
    }

    public boolean validarToken(String token) {
        return tokens.containsKey(token) && tokens.get(token).isAfter(Instant.now());
    }

    public void renovarToken(String token) {
        if (tokens.containsKey(token)) {
            tokens.put(token, Instant.now().plusSeconds(300));
        }
    }
}
