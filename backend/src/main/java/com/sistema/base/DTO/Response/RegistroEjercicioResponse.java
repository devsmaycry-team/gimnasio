package com.sistema.base.DTO.Response;

public class RegistroEjercicioResponse {
    private Long id;
    private Long rutina_id;
    private Long ejercicio_id;
    private int series_hechas;
    private int repeticiones_hechas;
    private Double peso_real;
    private String observacion;
    public RegistroEjercicioResponse(Long id, Long rutina_id, Long ejercicio_id, int series_hechas,
            int repeticiones_hechas, Double peso_real, String observacion) {
        this.id = id;
        this.rutina_id = rutina_id;
        this.ejercicio_id = ejercicio_id;
        this.series_hechas = series_hechas;
        this.repeticiones_hechas = repeticiones_hechas;
        this.peso_real = peso_real;
        this.observacion = observacion;
    }
    public RegistroEjercicioResponse() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getRutina_id() {
        return rutina_id;
    }
    public void setRutina_id(Long rutina_id) {
        this.rutina_id = rutina_id;
    }
    public Long getEjercicio_id() {
        return ejercicio_id;
    }
    public void setEjercicio_id(Long ejercicio_id) {
        this.ejercicio_id = ejercicio_id;
    }
    public int getSeries_hechas() {
        return series_hechas;
    }
    public void setSeries_hechas(int series_hechas) {
        this.series_hechas = series_hechas;
    }
    public int getRepeticiones_hechas() {
        return repeticiones_hechas;
    }
    public void setRepeticiones_hechas(int repeticiones_hechas) {
        this.repeticiones_hechas = repeticiones_hechas;
    }
    public Double getPeso_real() {
        return peso_real;
    }
    public void setPeso_real(Double peso_real) {
        this.peso_real = peso_real;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    
}
