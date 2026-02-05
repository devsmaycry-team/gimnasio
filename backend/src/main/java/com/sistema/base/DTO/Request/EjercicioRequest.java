package com.sistema.base.DTO.Request;


public class EjercicioRequest {
    private String grupo_mucular;
    private String equipo;
    private String imagen_url;
    private String video_url;
    public EjercicioRequest() {
    }
    public EjercicioRequest(String grupo_mucular, String equipo, String imagen_url, String video_url) {
        this.grupo_mucular = grupo_mucular;
        this.equipo = equipo;
        this.imagen_url = imagen_url;
        this.video_url = video_url;
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
   
    
}
