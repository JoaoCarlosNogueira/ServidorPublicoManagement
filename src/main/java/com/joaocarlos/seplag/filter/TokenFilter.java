package com.joaocarlos.seplag.filter;

import com.joaocarlos.seplag.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class TokenFilter extends GenericFilterBean {
    private final TokenService tokenService;

    public TokenFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String token = httpRequest.getHeader("Authorization");

        if (token != null && tokenService.validarToken(token.replace("Bearer ", ""))) {
            SecurityContextHolder.getContext().setAuthentication(
                    new PreAuthenticatedAuthenticationToken("user", null, null)
            );
        }
        chain.doFilter(request, response);
    }
}
