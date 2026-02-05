package com.sistema.base.DTO.Request;

import java.time.LocalDate;

public class AsistenciaRequest {
    private Long socio_id;
    private String tipo;
    private LocalDate fecha_hora;

    public AsistenciaRequest() {
    }

    public AsistenciaRequest(Long socio_id, String tipo, LocalDate fecha_hora) {
        this.socio_id = socio_id;
        this.tipo = tipo;
        this.fecha_hora = fecha_hora;
    }

    public Long getSocio_id() {
        return socio_id;
    }

    public void setSocio_id(Long socio_id) {
        this.socio_id = socio_id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDate fecha_hora) {
        this.fecha_hora = fecha_hora;
    }
    
    
    
}
