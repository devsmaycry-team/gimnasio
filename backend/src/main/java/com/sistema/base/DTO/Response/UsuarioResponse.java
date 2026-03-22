package com.sistema.base.DTO.Response;

public class UsuarioResponse {

    private Long id;
    private String correo;
    private Boolean activo;
    private String nombre;
    private String apellido;

    public UsuarioResponse() {}

    public UsuarioResponse(Long id, String correo, Boolean activo, String nombre, String apellido) {
        this.id = id;
        this.correo = correo;
        this.activo = activo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}