package com.sistema.base.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
	public Persona persona;

	private String correo;
	private String password;
    private Boolean activo = false;
    private String verificationToken; 
    private String resetPasswordToken;
    private LocalDateTime resetPasswordTokenExpira;

    private LocalDateTime verificationTokenExpira;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference("UserRol-user")
    private List<UserRol> userRols = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Socio> socios;
    
    public Usuario(){

    }


    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public List<UserRol> getUserRols() {
        return userRols;
    }

    public void setUserRols(List<UserRol> userRols) {
        this.userRols = userRols;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public LocalDateTime getVerificationTokenExpira() {
        return verificationTokenExpira;
    }

    public void setVerificationTokenExpira(LocalDateTime verificationTokenExpira) {
        this.verificationTokenExpira = verificationTokenExpira;
    }

    public List<Socio> getSocios() {
        return socios;
    }

    public void setSocios(List<Socio> socios) {
        this.socios = socios;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public LocalDateTime getResetPasswordTokenExpira() {
        return resetPasswordTokenExpira;
    }

    public void setResetPasswordTokenExpira(LocalDateTime resetPasswordTokenExpira) {
        this.resetPasswordTokenExpira = resetPasswordTokenExpira;
    }
    
}
