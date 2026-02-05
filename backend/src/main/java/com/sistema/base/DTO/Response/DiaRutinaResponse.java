package com.sistema.base.DTO.Response;

import java.util.List;

public class DiaRutinaResponse {
    private Long id;
    private Long rutina_id;
    private String dia_semana;
    private List<RutinaEjercicioResponse> rutinaEjercicios;
    public DiaRutinaResponse() {
    }
    public DiaRutinaResponse(Long id, Long rutina_id, String dia_semana,
            List<RutinaEjercicioResponse> rutinaEjercicios) {
        this.id = id;
        this.rutina_id = rutina_id;
        this.dia_semana = dia_semana;
        this.rutinaEjercicios = rutinaEjercicios;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getRutina_id() {
        return rutina_id;
    }
    public void setRutina_id(Long rutina_id) {
        this.rutina_id = rutina_id;
    }
    public String getDia_semana() {
        return dia_semana;
    }
    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }
    public List<RutinaEjercicioResponse> getRutinaEjercicios() {
        return rutinaEjercicios;
    }
    public void setRutinaEjercicios(List<RutinaEjercicioResponse> rutinaEjercicios) {
        this.rutinaEjercicios = rutinaEjercicios;
    }

    
}
