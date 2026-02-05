package com.sistema.base.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ejercicio {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String grupo_mucular;
    private String equipo;
    private String imagen_url;
    private String video_url;
    @OneToMany(mappedBy = "ejercicio", cascade = CascadeType.ALL)
    private List<RutinaEjercicio> rutinaEjercicios;
    @OneToMany(mappedBy = "ejercicio", cascade = CascadeType.ALL)
    private List<RegistroEjercicio> registroEjercicios;
    public Ejercicio() {
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
    public String getGrupo_mucular() {
        return grupo_mucular;
    }
    public void setGrupo_mucular(String grupo_mucular) {
        this.grupo_mucular = grupo_mucular;
    }
    public String getEquipo() {
        return equipo;
    }
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    public String getImagen_url() {
        return imagen_url;
    }
    public void setImagen_url(String imagen_url) {
        this.imagen_url = imagen_url;
    }
    public String getVideo_url() {
        return video_url;
    }
    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }
    public List<RutinaEjercicio> getRutinaEjercicios() {
        return rutinaEjercicios;
    }
    public void setRutinaEjercicios(List<RutinaEjercicio> rutinaEjercicios) {
        this.rutinaEjercicios = rutinaEjercicios;
    }
    public List<RegistroEjercicio> getRegistroEjercicios() {
        return registroEjercicios;
    }
    public void setRegistroEjercicios(List<RegistroEjercicio> registroEjercicios) {
        this.registroEjercicios = registroEjercicios;
    }

    
    
}
