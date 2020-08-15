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
public class Categoria {
    String id;
     String categoria;
     String descripcion;
  

    public Categoria() {
        
    }
        public Categoria (String id,String categoria,String descripcion ){
        
        this.id=id;
        this.categoria=categoria;
        this.descripcion=descripcion;
        
        
        
        
        
        
   
        }
        
        

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
