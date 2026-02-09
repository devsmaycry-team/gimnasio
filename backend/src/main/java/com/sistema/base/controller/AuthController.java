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
import com.sistema.base.DTO.ResetPasswordDTO;
import com.sistema.base.model.Usuario;
import com.sistema.base.security.AuthService;
import com.sistema.base.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UsuarioService usuarioService;

    public AuthController(AuthService authService, UsuarioService usuarioService) {
        this.authService = authService;
        this.usuarioService = usuarioService;
    }

    // -----------------------------
    // REGISTRO
    // -----------------------------
    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegistroDTO registroDTO) {
        try {
            Usuario usuario = authService.registrarUsuario(registroDTO);
            return ResponseEntity.ok(Map.of(
                "mensaje", "Usuario registrado. Revisa tu correo para activar la cuenta",
                "correo", usuario.getCorreo()
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", e.getMessage()));
        }
    }

    // -----------------------------
    // VERIFICACIÓN DE CUENTA
    // -----------------------------
    @GetMapping("/verify")
    public ResponseEntity<?> verificarUsuario(@RequestParam String token) {
        boolean verificado = authService.verificarUsuario(token);

        if (verificado) {
            return ResponseEntity.ok(
                    Map.of("mensaje", "Cuenta activada correctamente"));
        }

        return ResponseEntity.badRequest()
                .body(Map.of("error", "Token inválido o vencido"));
    }

    // -----------------------------
    // LOGIN
    // -----------------------------
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            String token = authService.login(
                    loginDTO.getEmail(),
                    loginDTO.getPassword());
            return ResponseEntity.ok(
                    Map.of("token", "Bearer " + token));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", e.getMessage()));
        }
    }

    // -----------------------------
    // SOLICITAR RESET DE PASSWORD
    // -----------------------------
    @PostMapping("/password/reset-request")
    public ResponseEntity<?> solicitarReset(@RequestParam String correo) {

        usuarioService.solicitarResetPassword(correo);

        return ResponseEntity.ok(Map.of(
                "mensaje", "Si el correo existe, se enviará un email"));
    }

    // -----------------------------
    // RESET DE PASSWORD
    // -----------------------------
    @PostMapping("/password/reset")
    public ResponseEntity<?> resetearPassword(
            @RequestBody ResetPasswordDTO dto) {

        boolean ok = usuarioService.resetearPassword(
                dto.getToken(),
                dto.getNuevaPassword());

        if (!ok) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Token inválido o vencido"));
        }

        return ResponseEntity.ok(
                Map.of("mensaje", "Contraseña actualizada correctamente"));
    }
}
