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
public class CampoComportamiento {
    
       String id;
     String id_campo_proceso;
      String id_paso;
      String nombre_campo;
       String numero_campo;
        String dato;
         String descripcion;
       
    public CampoComportamiento() {
        
    }
        public CampoComportamiento (String id,String id_campo_proceso,String id_paso,String nombre_campo,String numero_campo,String dato,String descripcion){
        
        this.id=id;
        this.id_campo_proceso=id_campo_proceso;
        this.id_paso=id_paso;
        this.nombre_campo=nombre_campo;
        this.numero_campo=numero_campo;
        this.dato=dato;
        this.descripcion=descripcion;
        
 
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_campo_proceso() {
        return id_campo_proceso;
    }

    public void setId_campo_proceso(String id_campo_proceso) {
        this.id_campo_proceso = id_campo_proceso;
    }

    public String getId_paso() {
        return id_paso;
    }

    public void setId_paso(String id_paso) {
        this.id_paso = id_paso;
    }

    public String getNombre_campo() {
        return nombre_campo;
    }

    public void setNombre_campo(String nombre_campo) {
        this.nombre_campo = nombre_campo;
    }

    public String getNumero_campo() {
        return numero_campo;
    }

    public void setNumero_campo(String numero_campo) {
        this.numero_campo = numero_campo;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
        
        
        
}
