package com.sistema.base.DTO.Request;

public class SocioRequest {
    private Long usuario_id;
    private Long numero_socio;
    private String observacionMedica;
    public SocioRequest() {
    }
    public SocioRequest(Long usuario_id, Long numero_socio, String observacionMedica) {
        this.usuario_id = usuario_id;
        this.numero_socio = numero_socio;
        this.observacionMedica = observacionMedica;
    }
    public Long getUsuario_id() {
        return usuario_id;
    }
    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }
    public Long getNumero_socio() {
        return numero_socio;
    }
    public void setNumero_socio(Long numero_socio) {
        this.numero_socio = numero_socio;
    }
    public String getObservacionMedica() {
        return observacionMedica;
    }
    public void setObservacionMedica(String observacionMedica) {
        this.observacionMedica = observacionMedica;
    }

    
}
