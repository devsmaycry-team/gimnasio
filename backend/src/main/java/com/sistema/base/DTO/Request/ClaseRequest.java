package com.sistema.base.DTO.Request;

public class ClaseRequest {
    private Long entrenador_id;
    private int cupo_maximo;
    private Long gimnasio_id;
    public ClaseRequest() {
    }
    public ClaseRequest(Long entrenador_id, int cupo_maximo, Long gimnasio_id) {
        this.entrenador_id = entrenador_id;
        this.cupo_maximo = cupo_maximo;
        this.gimnasio_id = gimnasio_id;
    }
    public Long getEntrenador_id() {
        return entrenador_id;
    }
    
    public void setEntrenador_id(Long entrenador_id) {
        this.entrenador_id = entrenador_id;
    }
    public int getCupo_maximo() {
        return cupo_maximo;
    }
    public void setCupo_maximo(int cupo_maximo) {
        this.cupo_maximo = cupo_maximo;
    }
    public Long getGimnasio_id() {
        return gimnasio_id;
    }
    public void setGimnasio_id(Long gimnasio_id) {
        this.gimnasio_id = gimnasio_id;
    }
    
    
    
}
