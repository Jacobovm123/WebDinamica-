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
public class ProcesoCampo {
    
    
    
    String id;
     String idproceso;
      String nombrecampo;
       String numerocampo;
        String dato;
         String descripcion ;
         

    public ProcesoCampo() {
         
    }
        public ProcesoCampo (String id,String idproceso,String nombrecampo,String numerocampo,String dato,String descripcion){
        
        this.id=id;
        this.idproceso=idproceso;
        this.nombrecampo=nombrecampo;
        this.numerocampo=numerocampo;
        this.dato=dato;
        this.descripcion=descripcion;
        
        
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdproceso() {
        return idproceso;
    }

    public void setIdproceso(String idproceso) {
        this.idproceso = idproceso;
    }

    public String getNombrecampo() {
        return nombrecampo;
    }

    public void setNombrecampo(String nombrecampo) {
        this.nombrecampo = nombrecampo;
    }

    public String getNumerocampo() {
        return numerocampo;
    }

    public void setNumerocampo(String numerocampo) {
        this.numerocampo = numerocampo;
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
