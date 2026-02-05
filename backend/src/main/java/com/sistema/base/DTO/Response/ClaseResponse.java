package com.sistema.base.DTO.Response;

public class ClaseResponse {
    private Long id;
    private Long entrenador_id;
    private int cupo_maximo;
    public ClaseResponse() {
    }
    public ClaseResponse(Long id, Long entrenador_id, int cupo_maximo) {
        this.id = id;
        this.entrenador_id = entrenador_id;
        this.cupo_maximo = cupo_maximo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    
}
