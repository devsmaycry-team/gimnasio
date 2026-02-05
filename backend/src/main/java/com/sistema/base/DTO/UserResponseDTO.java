package com.sistema.base.DTO;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String direccion;
    private String rol;
}