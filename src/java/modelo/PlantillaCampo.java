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
public class PlantillaCampo {
    
       String id;
     String id_plantilla;
      String nombre_campo;
       String numero_campo;
        String dato;
         String descripcion;
       
    public PlantillaCampo() {
        
    }
        public PlantillaCampo (String id,String id_plantilla,String nombre_campo,String numero_campo,String dato,String descripcion){
        
        this.id=id;
        this.id_plantilla=id_plantilla;
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

    public String getId_plantilla() {
        return id_plantilla;
    }

    public void setId_plantilla(String id_plantilla) {
        this.id_plantilla = id_plantilla;
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
