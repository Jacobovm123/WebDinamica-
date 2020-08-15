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
public class PasoCampoComportamientoDAO {
       PreparedStatement ps; 
    ResultSet rs;
    Conexion c= new Conexion ();
    Connection con ;
    
    public List listar (){
    List <PasoCampoComportamiento>lista =new ArrayList <>();
   String sql ="select *from paso_campo_comportamiento";
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        PasoCampoComportamiento u= new PasoCampoComportamiento();
        u.setId(rs.getString(1));
          u.setId_plantilla_paso(rs.getString(2));
            u.setId_plantilla_campo(rs.getString(3));
              u.setNombre_campo(rs.getString(4));
                u.setNumero_campo(rs.getString(5));
                 u.setDato(rs.getString(6));
                  u.setDescripcion(rs.getString(7));
                    u.setId_plantilla(rs.getString(8));
                  
 
 
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
     
    public int agregar(PasoCampoComportamiento p){
        int r=0;
    String sql ="insert into paso_campo_comportamiento (id_plantilla_paso,id_plantilla_campo,nombre_campo,numero_campo,dato,descripcion,id_plantilla)values(?,?,?,?,?,?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
   // ps.setString(1,p.getId());
      ps.setString(1,p.getId_plantilla_paso());
        ps.setString(2,p.getId_plantilla_campo());
        ps.setString(3,p.getNombre_campo());
          ps.setString(4,p.getNumero_campo());
           ps.setString(5,p.getDato());
            ps.setString(6,p.getDescripcion());
             ps.setString(7,p.getId_plantilla());
    
    
    
    
   r= ps.executeUpdate();
   con.commit();
    if(r==1){
    r=1;
    }else{
    r=0;
    
    }
    }
    catch(Exception e){
    
        System.out.println("Error Paso Campo "+e);
    }
    return r;
    }
    
    
    public PasoCampoComportamiento listarId(String id){
    String sql ="select *from paso_campo_comportamiento where id_pasocomportamiento="+id;
    PasoCampoComportamiento  u =new PasoCampoComportamiento
        ();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setId_plantilla_paso(rs.getString(2));
          u.setId_plantilla_campo(rs.getString(3));
             u.setNombre_campo(rs.getString(4));
                u.setNumero_campo(rs.getString(5));
                  u.setDato(rs.getString(6));
                    u.setDescripcion(rs.getString(7));
                  u.setId_plantilla(rs.getString(8));
    
    
    }
    
    
    }
    catch(Exception e){
    
    
    }
    return u;
    }
    
    public int actualizar (PasoCampoComportamiento u){
        int r=0;
    String  sql="update paso_campo_comportamiento set id_plantilla_paso=?,id_plantilla_campo=?,nombre_campo=?,numero_campo=?,dato=?,descripcion=?,id_plantilla=? where id_pasocomportamiento=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
    
    ps.setString(1,u.getId_plantilla_paso());
        ps.setString(2,u.getId_plantilla_campo());
            ps.setString(3,u.getNombre_campo());
                ps.setString(4,u.getNumero_campo());
                     ps.setString(5,u.getDato());
                           ps.setString(6,u.getDescripcion());
               
                ps.setString(7,u.getId_plantilla());
               
               
                           ps.setInt(8,Integer.parseInt(u.getId()));
                        
                        
                           
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
    
    String sql="delete from paso_campo_comportamiento where id_pasocomportamiento=?";
    
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
