package com.sistema.base.DTO.Request;

import java.time.LocalDateTime;

import com.sistema.base.model.Membresia;

public class PagosRequest {
    private Long socio_id;
    private Long membresia_id;
    private Membresia membresia;
    private double monto;
    private String metodo_pago;
    private LocalDateTime fecha;
    private String referencia;
    public PagosRequest() {
    }
    public PagosRequest(Long socio_id, Long membresia_id, Membresia membresia, double monto, String metodo_pago,
            LocalDateTime fecha, String referencia) {
        this.socio_id = socio_id;
        this.membresia_id = membresia_id;
        this.membresia = membresia;
        this.monto = monto;
        this.metodo_pago = metodo_pago;
        this.fecha = fecha;
        this.referencia = referencia;
    }
    public Long getSocio_id() {
        return socio_id;
    }
    public void setSocio_id(Long socio_id) {
        this.socio_id = socio_id;
    }
    public Long getMembresia_id() {
        return membresia_id;
    }
    public void setMembresia_id(Long membresia_id) {
        this.membresia_id = membresia_id;
    }
    public Membresia getMembresia() {
        return membresia;
    }
    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public String getMetodo_pago() {
        return metodo_pago;
    }
    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    
}
