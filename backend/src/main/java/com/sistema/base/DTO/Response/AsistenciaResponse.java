
package com.sistema.base.DTO.Response;

import java.time.LocalDateTime;

public class AsistenciaResponse {

    private Long id;
    private Long socioId;
    private String tipo;
    private LocalDateTime fechaHora;

    public AsistenciaResponse() {
    }

    public AsistenciaResponse(Long id, Long socioId, String tipo, LocalDateTime fechaHora) {
        this.id = id;
        this.socioId = socioId;
        this.tipo = tipo;
        this.fechaHora = fechaHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSocioId() {
        return socioId;
    }

    public void setSocioId(Long socioId) {
        this.socioId = socioId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}
