package com.sistema.base.DTO.Request;


public class EjercicioRequest {
    private String grupo_muscular;
    private String equipo;
    private String imagen_url;
    private String video_url;
    public EjercicioRequest() {
    }
    public EjercicioRequest(String grupo_muscular, String equipo, String imagen_url, String video_url) {
        this.grupo_muscular = grupo_muscular;
        this.equipo = equipo;
        this.imagen_url = imagen_url;
        this.video_url = video_url;
    }
    public String getGrupo_muscular() {
        return grupo_muscular;
    }
    public void setGrupo_muscular(String grupo_muscular) {
        this.grupo_muscular = grupo_muscular;
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
