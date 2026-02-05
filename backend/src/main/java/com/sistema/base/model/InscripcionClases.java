package com.sistema.base.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InscripcionClases {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "horarios_clases_id")
    private HorariosClases horariosClases;
    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socio socio;
    public InscripcionClases() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public HorariosClases getHorariosClases() {
        return horariosClases;
    }
    public void setHorariosClases(HorariosClases horariosClases) {
        this.horariosClases = horariosClases;
    }
    public Socio getSocio() {
        return socio;
    }
    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    

}
