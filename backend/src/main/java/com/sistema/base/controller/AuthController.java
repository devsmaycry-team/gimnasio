package com.sistema.base.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.base.DTO.LoginDTO;
import com.sistema.base.DTO.RegistroDTO;
import com.sistema.base.model.Usuario;
import com.sistema.base.security.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegistroDTO registroDTO) {
        try {
            Usuario usuario = authService.registrarUsuario(registroDTO);
            return ResponseEntity.ok(Map.of(
                "mensaje", "Usuario registrado. Revisa tu correo para activar la cuenta",
                "correo", usuario.getCorreo()
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/verify")
    public ResponseEntity<?> verificarUsuario(@RequestParam String token) {
        boolean verificado = authService.verificarUsuario(token);
        if (verificado) {
            return ResponseEntity.ok(Map.of("mensaje", "Cuenta activada correctamente"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("error", "Token inválido o ya usado"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            String token = authService.login(loginDTO.getEmail(), loginDTO.getPassword());
            return ResponseEntity.ok(Map.of("token", "Bearer " + token));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
