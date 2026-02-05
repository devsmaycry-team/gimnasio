package com.sistema.base.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HorariosClases {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clase_id")
    private Clase clase;
    private String dia_semana;
    private LocalDate horaInicio;
    private LocalDate horaFin;
    public HorariosClases() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Clase getClase() {
        return clase;
    }
    public void setClase(Clase clase) {
        this.clase = clase;
    }
    public String getDia_semana() {
        return dia_semana;
    }
    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }
    public LocalDate getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(LocalDate horaInicio) {
        this.horaInicio = horaInicio;
    }
    public LocalDate getHoraFin() {
        return horaFin;
    }
    public void setHoraFin(LocalDate horaFin) {
        this.horaFin = horaFin;
    }

    
}
