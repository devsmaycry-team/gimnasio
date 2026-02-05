package com.sistema.base.DTO;

public class RegistroDTO {
   // Persona
    private String nombre;
    private String apellido;
    private String celular;

    // Usuario
    private String email;
    private String password;
    private String tipoRol;
    private String repeatPassword;

    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTipoRol() {
        return tipoRol;
    }
    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }
    public String getRepeatPassword() {
        return repeatPassword;
    }
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    
}