package com.sistema.base.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class DiasRutina {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "rutina_id")
    private Rutina rutina;
    @OneToMany(mappedBy = "diasRutina", cascade = CascadeType.ALL)
    private List<RutinaEjercicio> rutinaEjercicio;
    private String dia_semana;
    public DiasRutina() {
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
    public String getDia_semana() {
        return dia_semana;
    }
    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }
    public List<RutinaEjercicio> getRutinaEjercicio() {
        return rutinaEjercicio;
    }
    public void setRutinaEjercicio(List<RutinaEjercicio> rutinaEjercicio) {
        this.rutinaEjercicio = rutinaEjercicio;
    }

    
    
}
