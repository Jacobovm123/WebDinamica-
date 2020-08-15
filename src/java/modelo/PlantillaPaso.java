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
public class PlantillaPaso {
    
    String id;
     String id_plantilla;
      String numero_pasos;
       String nombre;
        String aprobadores;


    public PlantillaPaso() {
        
    }
        public PlantillaPaso (String id,String id_plantilla,String numero_pasos,String nombre,String aprobadores){
        
        this.id=id;
        this.id_plantilla=id_plantilla;
        this.numero_pasos=numero_pasos;
        this.nombre=nombre;
        this.aprobadores=aprobadores;
        
   
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

    public String getNumero_pasos() {
        return numero_pasos;
    }

    public void setNumero_pasos(String numero_pasos) {
        this.numero_pasos = numero_pasos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAprobadores() {
        return aprobadores;
    }

    public void setAprobadores(String aprobadores) {
        this.aprobadores = aprobadores;
    }
        
        
}
