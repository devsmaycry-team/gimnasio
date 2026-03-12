package com.sistema.base.DTO.Response;

import java.util.List;


public class EntrenadorResponse {
    private Long id;
    private Long usuario_id;
    private String especialidad;
    private String matricula;
    private List<RutinaResponse> rutinas;
    private Long gimnasio_id;
    public EntrenadorResponse() {
    }
    public EntrenadorResponse(Long id, Long usuario_id, String especialidad, String matricula,
            List<RutinaResponse> rutinas, Long gimnasio_id) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.especialidad = especialidad;
        this.matricula = matricula;
        this.rutinas = rutinas;
        this.gimnasio_id = gimnasio_id;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public List<RutinaResponse> getRutinas() {
        return rutinas;
    }
    public void setRutinas(List<RutinaResponse> rutinas) {
        this.rutinas = rutinas;
    }
    public Long getGimnasio_id() {
        return gimnasio_id;
    }
    public void setGimnasio_id(Long gimnasio_id) {
        this.gimnasio_id = gimnasio_id;
    }

    
}
