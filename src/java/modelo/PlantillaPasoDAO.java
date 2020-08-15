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
public class PlantillaPasoDAO {
      PreparedStatement ps; 
    ResultSet rs;
    Conexion c= new Conexion ();
    Connection con ;
    
    public List listar (){
    List <PlantillaPaso>lista =new ArrayList <>();
   String sql ="select *from plantilla_pasos";
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        PlantillaPaso u= new PlantillaPaso();
        u.setId(rs.getString(1));
          u.setId_plantilla(rs.getString(2));
            u.setNumero_pasos(rs.getString(3));
              u.setNombre(rs.getString(4));
                u.setAprobadores(rs.getString(5));
 
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
 
    
    public List listar2 (String id){
    List <PlantillaPaso>lista =new ArrayList <>();
   String sql ="select * from plantilla_pasos where id_plantilla="+id;
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        PlantillaPaso u= new PlantillaPaso();
        u.setId(rs.getString(1));
          u.setId_plantilla(rs.getString(2));
            u.setNumero_pasos(rs.getString(3));
              u.setNombre(rs.getString(4));
                u.setAprobadores(rs.getString(5));
 
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){
            System.out.println("Buscando pasos:"+e);
    }
    return lista;
    }
 
    
    public int agregar(PlantillaPaso p){
        int r=0;
    String sql ="insert into plantilla_pasos (id_plantilla,numero_pasos,nombre,aprobadores)values(?,?,?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
   // ps.setString(1,p.getId());
      ps.setInt(1,Integer.parseInt(p.getId_plantilla()));
        ps.setString(2,p.getNumero_pasos());
        ps.setString(3,p.getNombre());
          ps.setString(4,p.getAprobadores());
    
    
    
    
    
    
   r= ps.executeUpdate();
    if(r==1){
    r=1;
    }else{
    r=0;
    
    }
    }
    catch(Exception e){
    
        System.out.println("Error al agregar paso plantilla "+e);
    }
    return r;
    }
    
    
    public PlantillaPaso listarId(String id){
    String sql ="select *from plantilla_pasos where id_plantilla_paso="+id;
    PlantillaPaso u =new PlantillaPaso();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setId_plantilla(rs.getString(2));
          u.setNumero_pasos(rs.getString(3));
             u.setNombre(rs.getString(4));
                u.setAprobadores(rs.getString(5));
        
    }
    
    
    }
    catch(Exception e){
    
    
    }
    return u;
    }
    
    public int actualizar (PlantillaPaso u){
        int r=0;
    String  sql="update plantilla_pasos set id_plantilla=?,numero_pasos=?,nombre=?,aprobadores=? where id_plantilla_paso=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
    
    ps.setString(1,u.getId_plantilla());
        ps.setString(2,u.getNumero_pasos());
            ps.setString(3,u.getNombre());
                ps.setString(4,u.getAprobadores());
                           ps.setInt(5,Integer.parseInt(u.getId()));
                        
                        
                           
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
    
    String sql="delete from plantilla_pasos where id_plantilla_paso=?";
    
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
