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
public class ProcesoCampDAO {
           PreparedStatement ps; 
    ResultSet rs;
    Conexion c= new Conexion ();
    Connection con ;
    
    public List listar (){
    List <ProcesoCampo>lista =new ArrayList <>();
   String sql ="select *from proceso_campo";
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        ProcesoCampo u= new ProcesoCampo();
        u.setId(rs.getString(1));
          u.setIdproceso(rs.getString(2));
           
          u.setNombrecampo(rs.getString(3));
          
          u.setNumerocampo(rs.getString(4));
          
          u.setDato(rs.getString(5));
          
          u.setDescripcion(rs.getString(6));
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
    
      public int agregar(ProcesoCampo p){
        int r=0;
        
    String sql ="insert into proceso_campo (id_proceso,nombre_campo,numero_campo,dato,descripcion)values(?,?,?,?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
    //ps.setString(1,p.getId());
      ps.setString(1,p.getIdproceso());
         ps.setString(2,p.getNombrecampo());
            ps.setString(3,p.getNumerocampo());
               ps.setString(4,p.getDato());
                  ps.setString(5,p.getDescripcion());

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
      
      
     
    public ProcesoCampo listarId(String id){
    String sql ="select *from proceso_campo where id_rol="+id;
    ProcesoCampo u =new ProcesoCampo();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setIdproceso(rs.getString(2));
              u.setNombrecampo(rs.getString(3));
                     u.setNumerocampo(rs.getString(4));
                            u.setDato(rs.getString(5));
                                   u.setDescripcion(rs.getString(6));
  
    
    
    }
    
    
    }
    catch(Exception e){
    
    
    }
    return u;
    } 
      
      
    public int actualizar (ProcesoCampo u){
        int r=0;
    String  sql="update proceso_campo set id_proceso=?,nombre_campo=?,numero_campo=?,dato=?,descripcion=? where id_campo_proceso=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
        ps.setString(1,u.getIdproceso());
    ps.setString(2,u.getNombrecampo());
        ps.setString(3,u.getNumerocampo());
        ps.setString(4,u.getDato());
            ps.setString(5,u.getDescripcion());
      ps.setString(6,u.getId());
                        
                        
                           
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
    
    String sql="delete from proceso_campo where id_campo_proceso=?";
    
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
