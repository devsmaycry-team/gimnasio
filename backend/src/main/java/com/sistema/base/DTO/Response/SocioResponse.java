package com.sistema.base.DTO.Response;

import java.util.List;

public class SocioResponse {
    private Long id;
    private List<MedicionesResponse> mediciones;
    private List<MembresiaResponse> membresias;
    private List<PagosResponse> pagos;
    private List<AsistenciaResponse> asistencias;
    private List<InscripcionClasesResponse> inscripcionClases;
    private Long usuario_id;
    private Long numero_socio;
    private String observacionMedica;
    public SocioResponse() {
    }
    public SocioResponse(Long id, List<MedicionesResponse> mediciones, List<MembresiaResponse> membresias,
            List<PagosResponse> pagos, List<AsistenciaResponse> asistencias,
            List<InscripcionClasesResponse> inscripcionClases, Long usuario_id, Long numero_socio,
            String observacionMedica) {
        this.id = id;
        this.mediciones = mediciones;
        this.membresias = membresias;
        this.pagos = pagos;
        this.asistencias = asistencias;
        this.inscripcionClases = inscripcionClases;
        this.usuario_id = usuario_id;
        this.numero_socio = numero_socio;
        this.observacionMedica = observacionMedica;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<MedicionesResponse> getMediciones() {
        return mediciones;
    }
    public void setMediciones(List<MedicionesResponse> mediciones) {
        this.mediciones = mediciones;
    }
    public List<MembresiaResponse> getMembresias() {
        return membresias;
    }
    public void setMembresias(List<MembresiaResponse> membresias) {
        this.membresias = membresias;
    }
    public List<PagosResponse> getPagos() {
        return pagos;
    }
    public void setPagos(List<PagosResponse> pagos) {
        this.pagos = pagos;
    }
    public List<AsistenciaResponse> getAsistencias() {
        return asistencias;
    }
    public void setAsistencias(List<AsistenciaResponse> asistencias) {
        this.asistencias = asistencias;
    }
    public List<InscripcionClasesResponse> getInscripcionClases() {
        return inscripcionClases;
    }
    public void setInscripcionClases(List<InscripcionClasesResponse> inscripcionClases) {
        this.inscripcionClases = inscripcionClases;
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
