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
public class Socio {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<Mediciones> mediciones;
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<Membresia> membresias;
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<Pagos> pagos;
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<Asistencias> asistencias;
    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<InscripcionClases> inscripcionClases;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private Long numero_socio;
    private String observacionMedica;
    public Socio() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Mediciones> getMediciones() {
        return mediciones;
    }
    public void setMediciones(List<Mediciones> mediciones) {
        this.mediciones = mediciones;
    }
    public List<Membresia> getMembresias() {
        return membresias;
    }
    public void setMembresias(List<Membresia> membresias) {
        this.membresias = membresias;
    }
    public List<Pagos> getPagos() {
        return pagos;
    }
    public void setPagos(List<Pagos> pagos) {
        this.pagos = pagos;
    }
    public List<Asistencias> getAsistencias() {
        return asistencias;
    }
    public void setAsistencias(List<Asistencias> asistencias) {
        this.asistencias = asistencias;
    }
    public List<InscripcionClases> getInscripcionClases() {
        return inscripcionClases;
    }
    public void setInscripcionClases(List<InscripcionClases> inscripcionClases) {
        this.inscripcionClases = inscripcionClases;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
