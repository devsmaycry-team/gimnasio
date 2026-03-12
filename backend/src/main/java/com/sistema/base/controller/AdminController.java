package com.sistema.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sistema.base.security.AuthService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AuthService authService;

    @PutMapping("/usuarios/{id}/rol")
    public ResponseEntity<String> cambiarRolUsuario(
            @PathVariable Long id,
            @RequestParam String rol) {

        authService.cambiarRolUsuario(id, rol);
        return ResponseEntity.ok("Rol actualizado correctamente");
    }
}