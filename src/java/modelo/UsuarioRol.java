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
public class UsuarioRol {
        String idUsRol;
     String idRol;
      String idUs;
  

    public UsuarioRol() {
        
    }
        public UsuarioRol (String idUsRol,String idRol,String idUs){
        
        this.idUsRol=idUsRol;
        this.idRol=idRol;
        this.idUs=idUs;
   
        
        }

    public String getIdUsRol() {
        return idUsRol;
    }

    public void setIdUsRol(String idUsRol) {
        this.idUsRol = idUsRol;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getIdUs() {
        return idUs;
    }

    public void setIdUs(String idUs) {
        this.idUs = idUs;
    }


    
    
    
}
