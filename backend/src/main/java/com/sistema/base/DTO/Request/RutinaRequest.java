package com.sistema.base.DTO.Request;

public class RutinaRequest {
    private Long entrenador_id;
    private String nombre;
    private String objetivo;
    private String nivel;
    private String duracion_semanas;
    private boolean estado;
    private boolean editable;
    public RutinaRequest() {
    }
    public RutinaRequest(Long entrenador_id, String nombre, String objetivo, String nivel, String duracion_semanas,
            boolean estado, boolean editable) {
        this.entrenador_id = entrenador_id;
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.nivel = nivel;
        this.duracion_semanas = duracion_semanas;
        this.estado = estado;
        this.editable = editable;
    }
    public Long getEntrenador_id() {
        return entrenador_id;
    }
    public void setEntrenador_id(Long entrenador_id) {
        this.entrenador_id = entrenador_id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public String getDuracion_semanas() {
        return duracion_semanas;
    }
    public void setDuracion_semanas(String duracion_semanas) {
        this.duracion_semanas = duracion_semanas;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public boolean isEditable() {
        return editable;
    }
    public void setEditable(boolean editable) {
        this.editable = editable;
    } 

    
}
