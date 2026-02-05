package com.sistema.base.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mediciones {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;
    private LocalDate fecha;
    private Double peso;
    private Double grasa_corporal;
    private Double pecho;
    private Double brazos;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Socio getSocio() {
        return socio;
    }
    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public Double getGrasa_corporal() {
        return grasa_corporal;
    }
    public void setGrasa_corporal(Double grasa_corporal) {
        this.grasa_corporal = grasa_corporal;
    }
    public Double getPecho() {
        return pecho;
    }
    public void setPecho(Double pecho) {
        this.pecho = pecho;
    }
    public Double getBrazos() {
        return brazos;
    }
    public void setBrazos(Double brazos) {
        this.brazos = brazos;
    }

    
}
