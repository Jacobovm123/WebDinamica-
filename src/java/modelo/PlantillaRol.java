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
public class PlantillaRol {
    
    String id;
     String id_plantilla;
      String id_rol;

    public PlantillaRol() {
        
    }
        public PlantillaRol (String id,String id_plantilla,String id_rol){
        
        this.id=id;
        this.id_plantilla=id_plantilla;
        this.id_rol=id_rol;
        
        
    
        
   
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

    public String getId_rol() {
        return id_rol;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }
        
        
        

}
