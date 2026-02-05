package com.sistema.base.DTO.Response;

import java.time.LocalDateTime;

import com.sistema.base.model.Membresia;

public class PagosResponse {
    private long id;
    private Long socio_id;
    private Long membresia_id;
    private Membresia membresia;
    private double monto;
    private String metodo_pago;
    private LocalDateTime fecha;
    public PagosResponse() {
    }
    public PagosResponse(long id, Long socio_id, Long membresia_id, Membresia membresia, double monto,
            String metodo_pago, LocalDateTime fecha) {
        this.id = id;
        this.socio_id = socio_id;
        this.membresia_id = membresia_id;
        this.membresia = membresia;
        this.monto = monto;
        this.metodo_pago = metodo_pago;
        this.fecha = fecha;
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

    
}
