package com.sistema.base.DTO.Response;

public class InscripcionClasesResponse {

    private Long id;
    private Long horariosClases_id;
    private Long socio_id;

    public InscripcionClasesResponse() {
    }

    public InscripcionClasesResponse(Long id, Long horariosClases_id, Long socio_id) {
        this.id = id;
        this.horariosClases_id = horariosClases_id;
        this.socio_id = socio_id;
    }

    public Long getId() {
        return id;
    }

    public Long getHorariosClases_id() {
        return horariosClases_id;
    }

    public Long getSocio_id() {
        return socio_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHorariosClases_id(Long horariosClases_id) {
        this.horariosClases_id = horariosClases_id;
    }

    public void setSocio_id(Long socio_id) {
        this.socio_id = socio_id;
    }
}
