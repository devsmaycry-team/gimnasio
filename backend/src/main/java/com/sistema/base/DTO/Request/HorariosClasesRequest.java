package com.sistema.base.DTO.Request;

import java.time.LocalTime;

public class HorariosClasesRequest {

    private Long clase_id;
    private String dia_semana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public HorariosClasesRequest() {
    }

    public HorariosClasesRequest(Long clase_id, String dia_semana, LocalTime horaInicio, LocalTime horaFin) {
        this.clase_id = clase_id;
        this.dia_semana = dia_semana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Long getClase_id() {
        return clase_id;
    }

    public void setClase_id(Long clase_id) {
        this.clase_id = clase_id;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }
}
