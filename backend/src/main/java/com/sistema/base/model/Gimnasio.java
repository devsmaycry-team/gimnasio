package com.sistema.base.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Gimnasio {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @OneToMany(mappedBy = "gimnasio", cascade = CascadeType.ALL)
    @JsonBackReference("gym-socio")
    private List<Socio> socios = new ArrayList<>();

    @OneToMany(mappedBy = "gimnasio", cascade = CascadeType.ALL)
    @JsonBackReference("gym-entrenador")
    private List<Entrenador> entrenadores = new ArrayList<>();

    @OneToMany(mappedBy = "gimnasio", cascade = CascadeType.ALL)
    @JsonBackReference("gym-plan")
    private List<Plan> planes = new ArrayList<>();

    @OneToMany(mappedBy = "gimnasio", cascade = CascadeType.ALL)
    @JsonBackReference("gym-clase")
    private List<Clase> clases = new ArrayList<>();
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String codigoGym;
    
    public Gimnasio() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Socio> getSocios() {
        return socios;
    }
    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }
    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }
    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }
    public List<Plan> getPlanes() {
        return planes;
    }
    public void setPlanes(List<Plan> planes) {
        this.planes = planes;
    }
    public List<Clase> getClases() {
        return clases;
    }
    public void setClases(List<Clase> clases) {
        this.clases = clases;
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
    public String getCodigo_gym() {
        return codigoGym;
    }
    public void setCodigo_gym(String codigo_gym) {
        this.codigoGym = codigo_gym;
    }

    
}
