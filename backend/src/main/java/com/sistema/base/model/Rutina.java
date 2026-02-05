package com.sistema.base.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Rutina {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;
    @OneToMany(mappedBy = "rutina", cascade = CascadeType.ALL)
    private List<DiasRutina> diasRutinas;
    @OneToMany(mappedBy = "rutina", cascade = CascadeType.ALL)
    private List<RegistroEjercicio> registroEjercicios;
    private String nombre;
    private String objetivo;
    private String nivel;
    private String duracion_semanas;
    private boolean estado;
    private boolean editable; //esto es para que el usuario pueda modificarlo a gusto
    public Rutina() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Entrenador getEntrenador() {
        return entrenador;
    }
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    public List<DiasRutina> getDiasRutinas() {
        return diasRutinas;
    }
    public void setDiasRutinas(List<DiasRutina> diasRutinas) {
        this.diasRutinas = diasRutinas;
    }
    public List<RegistroEjercicio> getRegistroEjercicios() {
        return registroEjercicios;
    }
    public void setRegistroEjercicios(List<RegistroEjercicio> registroEjercicios) {
        this.registroEjercicios = registroEjercicios;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public String getDuracion_semanas() {
        return duracion_semanas;
    }
    public void setDuracion_semanas(String duracion_semanas) {
        this.duracion_semanas = duracion_semanas;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public boolean isEditable() {
        return editable;
    }
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    
}
