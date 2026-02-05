package com.sistema.base.DTO.Request;


public class InscripcionClasesRequest {
     private Long horariosClases_id;
     private Long socio;
     public InscripcionClasesRequest() {
     }
     public InscripcionClasesRequest(Long horariosClases_id, Long socio) {
        this.horariosClases_id = horariosClases_id;
        this.socio = socio;
     }
     public Long getHorariosClases_id() {
         return horariosClases_id;
     }
     public void setHorariosClases_id(Long horariosClases_id) {
         this.horariosClases_id = horariosClases_id;
     }
     public Long getSocio() {
         return socio;
     }
     public void setSocio(Long socio) {
         this.socio = socio;
     }

     
}
