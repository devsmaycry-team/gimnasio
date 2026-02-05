package com.sistema.base.DTO.Response;

import java.time.LocalDateTime;
import java.util.List;

public class MembresiaResponse {
    private Long id;
    private Long socio_id;
    private Long plan_id;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private boolean estado;
    private List<PagosResponse> pagos;
    public MembresiaResponse() {
    }
    public MembresiaResponse(Long id, Long socio_id, Long plan_id, LocalDateTime fecha_inicio, LocalDateTime fecha_fin,
            boolean estado, List<PagosResponse> pagos) {
        this.id = id;
        this.socio_id = socio_id;
        this.plan_id = plan_id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.pagos = pagos;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getSocio_id() {
        return socio_id;
    }
    public void setSocio_id(Long socio_id) {
        this.socio_id = socio_id;
    }
    public Long getPlan_id() {
        return plan_id;
    }
    public void setPlan_id(Long plan_id) {
        this.plan_id = plan_id;
    }
    public LocalDateTime getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }
    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public List<PagosResponse> getPagos() {
        return pagos;
    }
    public void setPagos(List<PagosResponse> pagos) {
        this.pagos = pagos;
    }

    
}
