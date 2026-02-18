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

    @OneToMany(mappedBy = "diasRutina", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RutinaEjercicio> rutinaEjercicios;

    private String diaSemana;

    // 👉 ESTE ES EL QUE TE FALTABA (para evitar el error getOrden())
    private Integer orden;

    public DiasRutina() {
    }

    // ================= GETTERS Y SETTERS =================

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

    public List<RutinaEjercicio> getRutinaEjercicios() {
        return rutinaEjercicios;
    }

    public void setRutinaEjercicios(List<RutinaEjercicio> rutinaEjercicios) {
        this.rutinaEjercicios = rutinaEjercicios;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}
