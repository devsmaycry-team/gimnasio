package com.sistema.base.DTO.Request;

public class GimnasioRequest {
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String codigoGym;
    
    public GimnasioRequest() {
    }
    
    public GimnasioRequest(String nombre, String direccion, String telefono, String email, String codigoGym) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.codigoGym = codigoGym;
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
