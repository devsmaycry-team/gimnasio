package com.sistema.base.DTO.Request;

public class DiaRutinaRequest {
    private Long rutina_id;
    private String dia_semana;
    public DiaRutinaRequest() {
    }
    public DiaRutinaRequest(Long rutina_id, String dia_semana) {
        this.rutina_id = rutina_id;
        this.dia_semana = dia_semana;
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

    
}
