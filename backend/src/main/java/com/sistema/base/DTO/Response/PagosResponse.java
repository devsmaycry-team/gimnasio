package com.sistema.base.DTO.Response;

import java.time.LocalDateTime;

public class PagosResponse {

    private Long id;
    private Long socio_id;
    private Long membresia_id;
    private double monto;
    private String metodo_pago;
    private LocalDateTime fecha;
    private String referencia;

    public PagosResponse() {
    }

    public PagosResponse(Long id, Long socio_id, Long membresia_id,
                         double monto, String metodo_pago,
                         LocalDateTime fecha, String referencia) {
        this.id = id;
        this.socio_id = socio_id;
        this.membresia_id = membresia_id;
        this.monto = monto;
        this.metodo_pago = metodo_pago;
        this.fecha = fecha;
        this.referencia = referencia;
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

    public Long getMembresia_id() {
        return membresia_id;
    }

    public void setMembresia_id(Long membresia_id) {
        this.membresia_id = membresia_id;
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
