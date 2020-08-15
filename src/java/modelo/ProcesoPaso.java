/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jacob
 */
public class ProcesoPaso {
    
    
       String id;
     String id_proceso;
      String nombre_paso_proceso;
      String paso_estado;
       String pasos;
        String fecha;
         String aprobadores;
   
    public ProcesoPaso() {
        
    }
        public ProcesoPaso (String id,String id_proceso,String nombre_paso_proceso,String paso_estado,String pasos,String fecha,String aprobadores){
        
        this.id=id;
        this.id_proceso=id_proceso;
        this.nombre_paso_proceso=nombre_paso_proceso;
        this.paso_estado=paso_estado;
        this.pasos=pasos;
        this.fecha=fecha;
        this.aprobadores=aprobadores;
       
        
 
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_proceso() {
        return id_proceso;
    }

    public void setId_proceso(String id_proceso) {
        this.id_proceso = id_proceso;
    }

    public String getNombre_paso_proceso() {
        return nombre_paso_proceso;
    }

    public void setNombre_paso_proceso(String nombre_paso_proceso) {
        this.nombre_paso_proceso = nombre_paso_proceso;
    }

    public String getPaso_estado() {
        return paso_estado;
    }

    public void setPaso_estado(String paso_estado) {
        this.paso_estado = paso_estado;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAprobadores() {
        return aprobadores;
    }

    public void setAprobadores(String aprobadores) {
        this.aprobadores = aprobadores;
    }
    
        
        
        
    
    
}
