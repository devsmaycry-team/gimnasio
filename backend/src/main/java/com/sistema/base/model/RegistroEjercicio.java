package com.sistema.base.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RegistroEjercicio {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "rutina_id")
    private Rutina rutina;
    @ManyToOne
    @JoinColumn(name = "ejercicio_id")
    private Ejercicio ejercicio;
    private int series_hechas;
    private int repeticiones_hechas;
    private Double peso_real;
    private String observacion;
    public RegistroEjercicio() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Rutina getRutina() {
        return rutina;
    }
    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }
    public Ejercicio getEjercicio() {
        return ejercicio;
    }
    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
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
