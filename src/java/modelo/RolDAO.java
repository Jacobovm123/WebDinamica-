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
public class RolDAO {
       PreparedStatement ps; 
    ResultSet rs;
    Conexion c= new Conexion ();
    Connection con ;
    
    public List listar (){
    List <Rol>lista =new ArrayList <>();
   String sql ="select *from rol";
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        Rol u= new Rol();
        u.setId(rs.getString(1));
          u.setNombre(rs.getString(2));
           
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
    
      public int agregar(Rol p){
        int r=0;
        
    String sql ="insert into rol (id_rol,nombre_rol)values(?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
    ps.setString(1,p.getId());
      ps.setString(2,p.getNombre());

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
      
      
     
    public Rol listarId(String id){
    String sql ="select *from rol where id_rol="+id;
    Rol u =new Rol();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setNombre(rs.getString(2));
  
    
    
    }
    
    
    }
    catch(Exception e){
    
    
    }
    return u;
    } 
      
      
    public int actualizar (Rol u){
        int r=0;
    String  sql="update rol set nombre_rol=? where id_rol=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
    
    ps.setString(1,u.getNombre());
      ps.setString(2,u.getId());
                        
                        
                           
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
    
    String sql="DELETE from rol where id_rol="+id;
    
    try{
        con=c.conectar();
        ps=con.prepareStatement(sql);
               
        ps.executeUpdate();
    }
    catch (Exception e){
    
        System.out.println("Error al eliminar"+e);
            
    
    }
    
    
    }    
    
}
