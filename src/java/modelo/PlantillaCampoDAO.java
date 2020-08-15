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
public class PlantillaCampoDAO {
    PreparedStatement ps; 
    ResultSet rs;
    Conexion c= new Conexion ();
    Connection con ;
    
    public List listar (){
    List <PlantillaCampo>lista =new ArrayList <>();
   String sql ="select *from plantilla_campo";
      //  String sql ="select id_plantilla,nombre_campo, numero_campo,dato from plantilla_campo where id_plantilla_campo="+id;
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
       PlantillaCampo u= new PlantillaCampo();
        u.setId(rs.getString(1));
          u.setId_plantilla(rs.getString(2));
            u.setNombre_campo(rs.getString(3));
              u.setNumero_campo(rs.getString(4));
                u.setDato(rs.getString(5));
                  u.setDescripcion(rs.getString(6));
                  
                    
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
    
    
   //-------------------------------------
    
        public PlantillaCampo listarId1(String id){
         String sql ="select id_plantilla_campo, id_plantilla,nombre_campo, numero_campo,dato from plantilla_campo where id_plantilla_campo="+id;     
            
  //  String sql ="select *from plantilla_campo where id_plantilla_campo="+id;
    PlantillaCampo u =new PlantillaCampo();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setId_plantilla(rs.getString(2));
          u.setNombre_campo(rs.getString(3));
             u.setNumero_campo(rs.getString(4));
                u.setDato(rs.getString(5));
            
                     
    
    
    }
    
    
    }
    catch(Exception e){
    
    
    }
    return u;
    }
    
    
    
    
    
        public List listar4 (String id){
    List <PlantillaCampo>lista =new ArrayList <>();
  //String sql ="select *from plantilla_campo";
      String sql ="select id_plantilla,nombre_campo, numero_campo,dato from plantilla_campo where id_plantilla_campo="+id;
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
       PlantillaCampo u= new PlantillaCampo();
        u.setId(rs.getString(1));
          u.setId_plantilla(rs.getString(2));
            u.setNombre_campo(rs.getString(3));
              u.setNumero_campo(rs.getString(4));
                u.setDato(rs.getString(5));
         
                  
                    
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
    
    
    
    
    
      public List listar2 (String id){
    List <PlantillaCampo>lista =new ArrayList <>();
   String sql ="select *from plantilla_campo where id_plantilla="+id;
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
       PlantillaCampo u= new PlantillaCampo();
        u.setId(rs.getString(1));
          u.setId_plantilla(rs.getString(2));
            u.setNombre_campo(rs.getString(3));
              u.setNumero_campo(rs.getString(4));
                u.setDato(rs.getString(5));
                  u.setDescripcion(rs.getString(6));
                  
                    
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
     
    
    public int agregar(PlantillaCampo p){
        int r=0;
    String sql ="insert into plantilla_campo (id_plantilla,nombre_campo,numero_campo,dato,descripcion)values(?,?,?,?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
    //ps.setString(1,p.getId());
      ps.setString(1,p.getId_plantilla());
        ps.setString(2,p.getNombre_campo());
    
      ps.setString(3,p.getNumero_campo());
    
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
    
    
    public PlantillaCampo listarId(String id){
    String sql ="select *from plantilla_campo where id_plantilla_campo="+id;
    PlantillaCampo u =new PlantillaCampo();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setId_plantilla(rs.getString(2));
          u.setNombre_campo(rs.getString(3));
             u.setNumero_campo(rs.getString(4));
                u.setDato(rs.getString(5));
                   u.setDescripcion(rs.getString(6));
                     
    
    
    }
    
    
    }
    catch(Exception e){
    
    
    }
    return u;
    }
    
    
    
    
    
    
    
    
    
    
    
     public PlantillaCampo listarid(String id){
        
    String sql ="select id_plantilla,nombre_campo, numero_campo,dato from plantilla_campo where id_plantilla_campo="+id;
    PlantillaCampo u =new PlantillaCampo();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setId_plantilla(rs.getString(2));
          u.setNombre_campo(rs.getString(3));
             u.setNumero_campo(rs.getString(4));
                u.setDato(rs.getString(5));  
                 
    
    
    }
    
    
    }
    catch(Exception e){
    
    
    }
    return u;
    }
    
    
    
    
    
    
    
    
    
    public int actualizar (PlantillaCampo u){
        int r=0;
    String  sql="update plantilla_campo set id_plantilla=?,nombre_campo=?,numero_campo=?,dato=?,descripcion=? where id_plantilla_campo=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
    
    ps.setString(1,u.getId_plantilla());
        ps.setString(2,u.getNombre_campo());
            ps.setString(3,u.getNumero_campo());
                ps.setString(4,u.getDato());
                    ps.setString(5,u.getDescripcion());
                       
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
    
    String sql="delete from plantilla_campo where id_plantilla_campo=?";
    
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
