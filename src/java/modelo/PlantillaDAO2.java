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
public class PlantillaDAO2 {
    
    PreparedStatement ps; 
    ResultSet rs;
    Conexion c= new Conexion ();
    Connection con ;
    
    public List listar (){
    List <Plantilla2>lista =new ArrayList <>();
   String sql ="select *from plantilla";
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        Plantilla2 u= new Plantilla2();
        u.setId(rs.getString(1));
          u.setIdcategoria(rs.getString(2));
            u.setNombre(rs.getString(3));
              u.setFecha(rs.getString(4));
                u.setDescripcion(rs.getString(5));
                  u.setIniciarlas(rs.getString(6));
                  
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
     
    public int agregar(Plantilla2 p){
        int r=0;
    String sql ="insert into plantilla (id_categoria,nombre,fecha,descripcion,iniciarlas)values(?,?,?,?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
   // ps.setString(1,p.getId());
      ps.setString(1,p.getIdcategoria());
        ps.setString(2,p.getNombre());
    
      ps.setString(3,p.getFecha());
    
      ps.setString(4,p.getDescripcion());
    
      ps.setString(5,p.getIniciarlas());
    
    
    
    
    
    
    
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
    


    
    
    
    public Plantilla2 listarId(String id){
        
    String sql ="select *from plantilla where id_plantilla="+id;
    Plantilla2 u =new Plantilla2();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setIdcategoria(rs.getString(2));
          u.setNombre(rs.getString(3));
             u.setFecha(rs.getString(4));
                u.setDescripcion(rs.getString(5));
                   u.setIniciarlas(rs.getString(6));
                 
    
    
    }
    
    
    }
    catch(Exception e){
    
    
    }
    return u;
    }
    
    
    
    
    

  


    
    public int actualizar (Plantilla2 u){
        int r=0;
    String  sql="update plantilla set id_categoria=?,nombre=?,fecha=?,descripcion=?,iniciarlas=? where id_plantilla=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
    
    ps.setString(1,u.getIdcategoria());
        ps.setString(2,u.getNombre());
            ps.setString(3,u.getFecha());
                ps.setString(4,u.getDescripcion());
                    ps.setString(5,u.getIniciarlas());
                        
                           ps.setInt(6,Integer.parseInt(u.getId()));
                        
                        
                           
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
    
    String sql="delete from plantilla where id_plantilla=?";
    
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
