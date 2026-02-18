package com.sistema.base.DTO.Request;

public class InscripcionClasesRequest {

    private Long horariosClases_id;
    private Long socio_id;

    public InscripcionClasesRequest() {
    }

    public InscripcionClasesRequest(Long horariosClases_id, Long socio_id) {
        this.horariosClases_id = horariosClases_id;
        this.socio_id = socio_id;
    }

    public Long getHorariosClases_id() {
        return horariosClases_id;
    }

    public void setHorariosClases_id(Long horariosClases_id) {
        this.horariosClases_id = horariosClases_id;
    }

    public Long getSocio_id() {
        return socio_id;
    }

    public void setSocio_id(Long socio_id) {
        this.socio_id = socio_id;
    }
}
