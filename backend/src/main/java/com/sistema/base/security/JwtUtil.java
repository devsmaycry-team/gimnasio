package com.sistema.base.security;

import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION = 1000 * 60 * 60; // 1 hora

    // ------------------ GENERAR TOKEN ------------------
    public String generarToken(org.springframework.security.core.userdetails.User user) {
        String roles = user.getAuthorities().stream()
                .map(a -> a.getAuthority())
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(user.getUsername()) // email
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key)
                .compact();
    }

    // ------------------ OBTENER EMAIL ------------------
    public String getEmailFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // ------------------ MÉTODO ESTÁNDAR ------------------
    public String extractUsername(String token) {
        return getEmailFromToken(token);
    }

}
