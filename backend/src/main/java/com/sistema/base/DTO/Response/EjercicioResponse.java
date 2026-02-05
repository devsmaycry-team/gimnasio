package com.sistema.base.DTO.Response;

import java.util.List;

public class EjercicioResponse {
    private Long id;
    private String grupo_mucular;
    private String equipo;
    private String imagen_url;
    private String video_url;
    private List<RutinaEjercicioResponse> rutinaEjercicios;
    private List<RegistroEjercicioResponse> registroEjercicios;
    public EjercicioResponse() {
    }
    public EjercicioResponse(Long id, String grupo_mucular, String equipo, String imagen_url, String video_url,
            List<RutinaEjercicioResponse> rutinaEjercicios, List<RegistroEjercicioResponse> registroEjercicios) {
        this.id = id;
        this.grupo_mucular = grupo_mucular;
        this.equipo = equipo;
        this.imagen_url = imagen_url;
        this.video_url = video_url;
        this.rutinaEjercicios = rutinaEjercicios;
        this.registroEjercicios = registroEjercicios;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public List<RutinaEjercicioResponse> getRutinaEjercicios() {
        return rutinaEjercicios;
    }
    public void setRutinaEjercicios(List<RutinaEjercicioResponse> rutinaEjercicios) {
        this.rutinaEjercicios = rutinaEjercicios;
    }
    public List<RegistroEjercicioResponse> getRegistroEjercicios() {
        return registroEjercicios;
    }
    public void setRegistroEjercicios(List<RegistroEjercicioResponse> registroEjercicios) {
        this.registroEjercicios = registroEjercicios;
    }

    
}
