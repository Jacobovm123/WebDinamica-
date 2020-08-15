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
public class Plantilla2 {
    
    String id;
     String idcategoria;
      String nombre;
       String fecha;
        String descripcion;
         String iniciarlas;
       

    public Plantilla2() {
        
    }
        public  Plantilla2 (String id,String idcategoria,String nombre,String fecha,String descripcion,String iniciarlas){
        
        this.id=id;
        this.idcategoria=idcategoria;
        this.nombre=nombre;
        this.fecha=fecha;
        this.descripcion=descripcion;
        this.iniciarlas=iniciarlas;
       
        
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(String idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIniciarlas() {
        return iniciarlas;
    }

    public void setIniciarlas(String iniciarlas) {
        this.iniciarlas = iniciarlas;
    }




}


