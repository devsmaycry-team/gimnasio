package com.sistema.base.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RutinaEjercicio {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dias_rutina_id")
    private DiasRutina diasRutina;
    @ManyToOne
    @JoinColumn(name = "ejercicio_id")
    private Ejercicio ejercicio;
    private int series;
    private int repeticiones;
    private String peso_objetivo;
    private String descanso_seg;
    public RutinaEjercicio() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public DiasRutina getDiasRutina() {
        return diasRutina;
    }
    public void setDiasRutina(DiasRutina diasRutina) {
        this.diasRutina = diasRutina;
    }
    public Ejercicio getEjercicio() {
        return ejercicio;
    }
    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }
    public int getSeries() {
        return series;
    }
    public void setSeries(int series) {
        this.series = series;
    }
    public int getRepeticiones() {
        return repeticiones;
    }
    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }
    public String getPeso_objetivo() {
        return peso_objetivo;
    }
    public void setPeso_objetivo(String peso_objetivo) {
        this.peso_objetivo = peso_objetivo;
    }
    public String getDescanso_seg() {
        return descanso_seg;
    }
    public void setDescanso_seg(String descanso_seg) {
        this.descanso_seg = descanso_seg;
    }

    
}
