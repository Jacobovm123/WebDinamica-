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
public class PasoCampoComportamiento {
    
       String id;
     String id_plantilla_paso;
      String id_plantilla_campo;
      String nombre_campo;
       String numero_campo;
        String dato;
         String descripcion;
       String id_plantilla;
    public PasoCampoComportamiento() {
        
    }
        public PasoCampoComportamiento (String id,String id_plantilla_paso,String id_plantilla_campo,String nombre_campo,String numero_campo,String dato,String descripcion,String id_plantilla){
        
        this.id=id;
        this.id_plantilla_paso=id_plantilla_paso;
        this.id_plantilla_campo=id_plantilla_campo;
        this.nombre_campo=nombre_campo;
        this.numero_campo=numero_campo;
        this.dato=dato;
        this.descripcion=descripcion;
        this.id_plantilla=id_plantilla;
        
 
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_plantilla_paso() {
        return id_plantilla_paso;
    }

    public void setId_plantilla_paso(String id_plantilla_paso) {
        this.id_plantilla_paso = id_plantilla_paso;
    }

    public String getId_plantilla_campo() {
        return id_plantilla_campo;
    }

    public void setId_plantilla_campo(String id_plantilla_campo) {
        this.id_plantilla_campo = id_plantilla_campo;
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

    public String getId_plantilla() {
        return id_plantilla;
    }

    public void setId_plantilla(String id_plantilla) {
        this.id_plantilla = id_plantilla;
    }
        
        
        
        
        
}
