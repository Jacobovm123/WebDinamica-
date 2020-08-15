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
public class Proceso {
    
    
     String id;
     String id_plantilla;
     String id_usuario;
     String nombre_proceso;
     String estado_proceso;
String fecha;  

    public Proceso() {
        
    }
        public Proceso (String id,String id_plantilla,String id_usuario,String nombre_proceso,String estado_proceso,String fecha ){
        
        this.id=id;
        this.id_plantilla=id_plantilla;
        this.id_usuario=id_usuario;
        this.nombre_proceso=nombre_proceso;
        this.estado_proceso=estado_proceso;
        this.fecha=fecha;
   
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_plantilla() {
        return id_plantilla;
    }

    public void setId_plantilla(String id_plantilla) {
        this.id_plantilla = id_plantilla;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_proceso() {
        return nombre_proceso;
    }

    public void setNombre_proceso(String nombre_proceso) {
        this.nombre_proceso = nombre_proceso;
    }

    public String getEstado_proceso() {
        return estado_proceso;
    }

    public void setEstado_proceso(String estado_proceso) {
        this.estado_proceso = estado_proceso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
        
        
    
    
}
