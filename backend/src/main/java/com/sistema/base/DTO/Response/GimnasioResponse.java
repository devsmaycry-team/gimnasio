package com.sistema.base.DTO.Response;

public class GimnasioResponse {

    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String codigoGym;

    public GimnasioResponse() {
    }

    public GimnasioResponse(Long id, String nombre, String direccion, String telefono, String email, String codigoGym) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.codigoGym = codigoGym;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigoGym() {
        return codigoGym;
    }

    public void setCodigoGym(String codigoGym) {
        this.codigoGym = codigoGym;
    }
}