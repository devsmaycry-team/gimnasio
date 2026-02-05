package com.sistema.base.DTO.Response;

public class PlanResponse {
    private Long id;
    private String nombre;
    private double precio;
    private int duracion_dias;
    private int clases_incluidas;
    public PlanResponse() {
    }
    public PlanResponse(Long id, String nombre, double precio, int duracion_dias, int clases_incluidas) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.duracion_dias = duracion_dias;
        this.clases_incluidas = clases_incluidas;
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
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getDuracion_dias() {
        return duracion_dias;
    }
    public void setDuracion_dias(int duracion_dias) {
        this.duracion_dias = duracion_dias;
    }
    public int getClases_incluidas() {
        return clases_incluidas;
    }
    public void setClases_incluidas(int clases_incluidas) {
        this.clases_incluidas = clases_incluidas;
    }
    
}
