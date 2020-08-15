/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacob
 */
public class PlantillaRolDAO {
        PreparedStatement ps; 
    ResultSet rs;
    Conexion c= new Conexion ();
    Connection con ;
    
    public List listar (){
    List <PlantillaRol>lista =new ArrayList <>();
   String sql ="select *from plantilla_rol";
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        PlantillaRol u= new PlantillaRol();
        u.setId(rs.getString(1));
          u.setId_plantilla(rs.getString(2));
            u.setId_rol(rs.getString(3));
            
           
 
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
     
    public int agregar(PlantillaRol p){
        int r=0;
    String sql ="insert into plantilla_rol (id_plantilla,id_rol)values(?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
   // ps.setString(1,p.getId());
      ps.setString(1,p.getId_plantilla());
        ps.setString(2,p.getId_rol());
        
      
    
    
    
    
    
    
   r= ps.executeUpdate();
    if(r==1){
    r=1;
    }else{
    r=0;
    
    }
    }
    catch(Exception e){
    
    
    }
    return r;
    }
    
    
    public PlantillaRol listarId(String id){
    String sql ="select *from plantilla_rol where id_plantilla_rol="+id;
    PlantillaRol u =new PlantillaRol();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setId_plantilla(rs.getString(2));
          u.setId_rol(rs.getString(3));

    }
    
    
    }
    catch(Exception e){
    
    
    }
    return u;
    }
    
    public int actualizar (PlantillaRol u){
        int r=0;
    String  sql="update plantilla_rol set id_plantilla=?,id_rol=? where id_plantilla_rol=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
    
    ps.setString(1,u.getId_plantilla());
        ps.setString(2,u.getId_rol());

                           ps.setInt(3,Integer.parseInt(u.getId()));
                        
                        
                           
  r=ps.executeUpdate();
    
    if(r==1){
    
    r=1;
    
    }else{
    r=0;
            
    
    }
    }
    catch(Exception e){
            
            }
    return r;
    }
    
    
    public void delete(String id)
    {
    
    String sql="delete from plantilla_rol where id_plantilla_rol=?";
    
    try{
        System.out.println("Codigo"+id);
        con=c.conectar();
        ps=con.prepareStatement(sql);
               ps.setInt(1,Integer.parseInt(id));
        ps.executeUpdate();
    }
    catch (Exception e){
    
        System.out.println("Error al eliminar"+e);
            
    
    }
    
    
    }    
}
