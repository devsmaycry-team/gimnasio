package com.sistema.base.DTO.Response;

public class RutinaEjercicioResponse {
    private Long id;
    private Long dias_rutina_id;
    private Long ejercicio_id;
    private int series;
    private int repeticiones;
    private String peso_objetivo;
    private String descanso_seg;
    public RutinaEjercicioResponse() {
    }
    public RutinaEjercicioResponse(Long id, Long dias_rutina_id, Long ejercicio_id, int series, int repeticiones,
            String peso_objetivo, String descanso_seg) {
        this.id = id;
        this.dias_rutina_id = dias_rutina_id;
        this.ejercicio_id = ejercicio_id;
        this.series = series;
        this.repeticiones = repeticiones;
        this.peso_objetivo = peso_objetivo;
        this.descanso_seg = descanso_seg;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getDias_rutina_id() {
        return dias_rutina_id;
    }
    public void setDias_rutina_id(Long dias_rutina_id) {
        this.dias_rutina_id = dias_rutina_id;
    }
    public Long getEjercicio_id() {
        return ejercicio_id;
    }
    public void setEjercicio_id(Long ejercicio_id) {
        this.ejercicio_id = ejercicio_id;
    }
    public int getSeries() {
        return series;
    }
    public void setSeries(int series) {
        this.series = series;
    }
    public int getRepeticiones() {
        return repeticiones;
    }
    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }
    public String getPeso_objetivo() {
        return peso_objetivo;
    }
    public void setPeso_objetivo(String peso_objetivo) {
        this.peso_objetivo = peso_objetivo;
    }
    public String getDescanso_seg() {
        return descanso_seg;
    }
    public void setDescanso_seg(String descanso_seg) {
        this.descanso_seg = descanso_seg;
    }

    
}
