package com.sistema.base.DTO.Response;

public class InscripcionClasesResponse {
    private Long id;
    private Long horariosClases_id;
    private Long socio;
    public InscripcionClasesResponse() {
    }
    public InscripcionClasesResponse(Long id, Long horariosClases_id, Long socio) {
    this.id = id;
    this.horariosClases_id = horariosClases_id;
    this.socio = socio;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getHorariosClases_id() {
        return horariosClases_id;
    }
    public void setHorariosClases_id(Long horariosClases_id) {
        this.horariosClases_id = horariosClases_id;
    }
    public Long getSocio() {
        return socio;
    }
    public void setSocio(Long socio) {
        this.socio = socio;
    }

}
