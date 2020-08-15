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
public class CategoriaDAO {
    
    PreparedStatement ps; 
    ResultSet rs;
    Conexion c= new Conexion ();
    Connection con ;
    
    public List listar (){
    List <Categoria>lista =new ArrayList <>();
   String sql ="select *from categoria";
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        Categoria u= new Categoria();
        u.setId(rs.getString(1));
          u.setCategoria(rs.getString(2));
            u.setDescripcion(rs.getString(3));
            
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
     
    public int agregar(Categoria p){
        int r=0;
    String sql ="insert into categoria (id_categoria,categoria,descripcion)values(?,?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
    ps.setString(1,p.getId());
      ps.setString(2,p.getCategoria());
        ps.setString(3,p.getDescripcion());
    
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
    
    
   
    
    public int actualizar (Categoria u){
        int r=0;
    String  sql="update categoria set categoria=?,descripcion=? where id_categoria=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
    
    ps.setString(1,u.getCategoria());
        ps.setString(2,u.getDescripcion());
                           ps.setString(3,u.getId());
                        
                        
                           
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
    
    String sql="delete from categoria where id_categoria= "+id;
    
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
