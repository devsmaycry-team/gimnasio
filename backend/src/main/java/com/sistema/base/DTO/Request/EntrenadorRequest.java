package com.sistema.base.DTO.Request;


public class EntrenadorRequest {
    private Long usuario_id;
    private Long gimnasio_id;
    private String especialidad;
    private String matricula;
    public EntrenadorRequest() {
    }
    public EntrenadorRequest(Long usuario_id, String especialidad, String matricula, Long gimnasio_id) {
        this.usuario_id = usuario_id;
        this.especialidad = especialidad;
        this.matricula = matricula;
        this.gimnasio_id = gimnasio_id;
    }
    public Long getUsuario_id() {
        return usuario_id;
    }
    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public Long getGimnasio_id() {
        return gimnasio_id;
    }
    public void setGimnasio_id(Long gimnasio_id) {
        this.gimnasio_id = gimnasio_id;
    }

    
}
