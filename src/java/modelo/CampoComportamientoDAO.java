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
public class CampoComportamientoDAO {
           PreparedStatement ps; 
    ResultSet rs;
    Conexion c= new Conexion ();
    Connection con ;
    
    public List listar (){
    List <CampoComportamiento>lista =new ArrayList <>();
   String sql ="select *from campo_comportamiento";
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        CampoComportamiento u= new CampoComportamiento();
        u.setId(rs.getString(1));
          u.setId_campo_proceso(rs.getString(2));
            u.setId_paso(rs.getString(3));
              u.setNombre_campo(rs.getString(4));
                u.setNumero_campo(rs.getString(5));
                 u.setDato(rs.getString(6));
                  u.setDescripcion(rs.getString(7));
 
 
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
     
    
    ///------------------------
    
    
      public List listarp (String dato){
    List <CampoComportamiento>lista =new ArrayList <>();
   String sql ="select campo_comportamiento.id_pasocomportamiento, campo_comportamiento.nombre_campo\n" +
"from proceso_paso,campo_comportamiento \n" +
"where proceso_paso.id_paso=campo_comportamiento.id_paso and campo_comportamiento.id_paso='"+dato+"' ";
          System.out.println(sql);
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        CampoComportamiento u= new CampoComportamiento();
        u.setId(rs.getString(1));
              u.setNombre_campo(rs.getString(2));
        
 
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){
        System.out.println(e);
    }
    
    
    
    
    
    return lista;
    }
    
    
    
    //--------------------------------
    
    
    
    //----------------------inicio
      
    
          public int actualizar1 (CampoComportamiento u){
        int r=0;
    String  sql="update campo_comportamiento set descripcion=? where id_pasocomportamiento=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
                           ps.setString(1,u.getDescripcion());

                           ps.setInt(2,Integer.parseInt(u.getId()));
 
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
      
      
      
      //--------------------fin
    
    public int agregar(CampoComportamiento p){
        int r=0;
    String sql ="insert into campo_comportamiento (id_campo_proceso,id_paso,nombre_campo,numero_campo,dato,descripcion)values(?,?,?,?,?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
   // ps.setString(1,p.getId());
      ps.setString(1,p.getId_campo_proceso());
        ps.setString(2,p.getId_paso());
        ps.setString(3,p.getNombre_campo());
          ps.setString(4,p.getNumero_campo());
           ps.setString(5,p.getDato());
            ps.setString(6,p.getDescripcion());
    
    
    
    
    
    
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
    
    
    public CampoComportamiento listarId(String id){
    String sql ="select *from campo_comportamiento where id_pasocomportamiento="+id;
    CampoComportamiento  u =new CampoComportamiento
        ();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setId_campo_proceso(rs.getString(2));
          u.setId_paso(rs.getString(3));
             u.setNombre_campo(rs.getString(4));
                u.setNumero_campo(rs.getString(5));
                  u.setDato(rs.getString(6));
                    u.setDescripcion(rs.getString(7));
                 
    
    
    }
    
    
    }
    catch(Exception e){
    
    
    }
    return u;
    }
    
    public int actualizar (CampoComportamiento u){
        int r=0;
    String  sql="update campo_comportamiento set id_campo_proceso=?,id_paso=?,nombre_campo=?,numero_campo=?,dato=?,descripcion=? where id_pasocomportamiento=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
    
    ps.setString(1,u.getId_campo_proceso());
        ps.setString(2,u.getId_paso());
            ps.setString(3,u.getNombre_campo());
                ps.setString(4,u.getNumero_campo());
                     ps.setString(5,u.getDato());
                           ps.setString(6,u.getDescripcion());
               
               
                           ps.setInt(7,Integer.parseInt(u.getId()));
                        
                        
                           
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
    
    String sql="delete from campo_comportamiento where id_pasocomportamiento=?";
    
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
