package com.sistema.base.DTO.Response;

import java.time.LocalDateTime;

public class MedicionesResponse {
    private long id;
    private Long socio_id;
    private LocalDateTime fecha;
    private Double peso;
    private Double grasa_corporal;
    private Double pecho;
    private Double brazos;
    public MedicionesResponse() {
    }
    public MedicionesResponse(long id, Long socio_id, LocalDateTime fecha, Double peso, Double grasa_corporal,
            Double pecho, Double brazos) {
        this.id = id;
        this.socio_id = socio_id;
        this.fecha = fecha;
        this.peso = peso;
        this.grasa_corporal = grasa_corporal;
        this.pecho = pecho;
        this.brazos = brazos;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Long getSocio_id() {
        return socio_id;
    }
    public void setSocio_id(Long socio_id) {
        this.socio_id = socio_id;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public Double getGrasa_corporal() {
        return grasa_corporal;
    }
    public void setGrasa_corporal(Double grasa_corporal) {
        this.grasa_corporal = grasa_corporal;
    }
    public Double getPecho() {
        return pecho;
    }
    public void setPecho(Double pecho) {
        this.pecho = pecho;
    }
    public Double getBrazos() {
        return brazos;
    }
    public void setBrazos(Double brazos) {
        this.brazos = brazos;
    }

    
}
