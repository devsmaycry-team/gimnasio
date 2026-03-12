package com.sistema.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.sistema.base.security.AuthService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AuthService authService;

    @PreAuthorize("hasRole('ADMIN')")  // ✅ Solo admins
    @PutMapping("/usuarios/{id}/rol")
    public ResponseEntity<?> cambiarRolUsuario(
            @PathVariable Long id,
            @RequestParam Long rol) {  // Long en vez de String
        try {
            authService.cambiarRolUsuario(id, rol);
            return ResponseEntity.ok("Rol actualizado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/usuarios/{id}/rol")
    public ResponseEntity<?> quitarRolUsuario(
            @PathVariable Long id,
            @RequestParam Long rol) {
        try {
            authService.quitarRolUsuario(id, rol);
            return ResponseEntity.ok("Rol eliminado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/usuarios/{id}/rol/editar")
    public ResponseEntity<?> editarRolUsuario(
            @PathVariable Long id,
            @RequestParam Long rolViejo,
            @RequestParam Long rolNuevo) {
        try {
            authService.editarRolUsuario(id, rolViejo, rolNuevo);
            return ResponseEntity.ok("Rol actualizado correctamente");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}