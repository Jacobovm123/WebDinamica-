/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jacob
 */
public class ProcesoDAO {
    
ProcesoPaso u = new ProcesoPaso ();
    
    PreparedStatement ps; 
    ResultSet rs;
    Conexion c= new Conexion ();
    Connection con ;
    
    public List listar (){
    List <Proceso>lista =new ArrayList <>();
   String sql ="select *from proceso";
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        Proceso u= new Proceso();
        u.setId(rs.getString(1));
       u.setId_plantilla(rs.getString(2));
           u.setId_usuario(rs.getString(3));
               u.setNombre_proceso(rs.getString(4));
          u.setEstado_proceso(rs.getString(5));
              u.setFecha(rs.getString(6));
            
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
     
    public int agregar(Proceso p){
        int r=0;
        int cod2;
        
        
    String sqlSeq ="select secuenciaproceso.nextval from dual";
    Proceso u =new Proceso();
    int secuencia=0;
    con=c.conectar();
        try {
            ps=con.prepareStatement(sqlSeq);
            rs=ps.executeQuery();
    
            while(rs.next()){
    
            secuencia= rs.getInt("nextval");
    
    
            
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String sql ="insert into proceso (id_proceso,id_plantilla,id_usuario,nombre_proceso,estado_proceso,fecha)values(?,?,?,?,?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
   ps.setInt(1,secuencia);
      ps.setString(2,p.getId_plantilla());
          ps.setString(3,p.getId_usuario());
              ps.setString(4,p.getNombre_proceso());
        ps.setString(5,p.getEstado_proceso());
          ps.setString(6,p.getFecha());
    
   
          r= ps.executeUpdate();
   con.close();
   
    if(r==1){
    r=1;
    }else{
    r=0;
    
    }
    }
    catch(Exception e){
        System.out.println(e);
    
    }
    
    cod2=Integer.parseInt(p.getId_plantilla());
    String sqlPaso ="select * from plantilla_pasos where id_plantilla="+p.getId_plantilla();
    String aprobador="",pasos="",nombre="";
    
    con=c.conectar();
        try {
            ps=con.prepareStatement(sqlPaso);
            rs=ps.executeQuery();
    
            while(rs.next()){
                aprobador= rs.getString("aprobadores");
                nombre= rs.getString("nombre");
                pasos= rs.getString("numero_pasos");
                agregarPasoProceso(secuencia,nombre,pasos,aprobador);
            }
            con.close();
    
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    agregar1(secuencia,cod2);
    
    String sqlTr="insert into campo_comportamiento (id_paso,id_campo_proceso,nombre_campo,numero_campo,dato) \n" +
"select proceso_paso.id_paso,proceso_campo.id_campo_proceso,proceso_campo.nombre_campo,proceso_campo.numero_campo,proceso_campo.dato \n" +
"from plantilla_campo, proceso_campo,paso_campo_comportamiento, proceso_paso,plantilla_pasos \n" +
"where plantilla_campo.descripcion = proceso_campo.descripcion and proceso_paso.nombre_paso_proceso=plantilla_pasos.nombre||proceso_paso.id_proceso\n" +
"and plantilla_campo.id_plantilla_campo=paso_campo_comportamiento.id_plantilla_campo \n" +
"and plantilla_pasos.id_plantilla_paso=paso_campo_comportamiento.id_plantilla_paso and proceso_paso.id_proceso="+secuencia+" and proceso_campo.id_proceso="+secuencia;
    
    try{
        
        con=c.conectar();
        ps=con.prepareStatement(sqlTr);
        ps.executeUpdate();
    }
    catch (Exception e){
    
        System.out.println("Error al generar"+e);
            
    
    }
    
    
    
    return r;
    
    
    
    }
  
    
   //---------------------------------
    
    
    
      public int agregar1(int cod , int cod2){
        int r=0;
        
        
    int secuencia=cod;
    
    
    
    
    String sqlPaso ="select * from plantilla_campo where id_plantilla="+cod2;
   // String aprobador="",pasos="",nombre="";
    String nombrecampo="", numerocampo="", dato="",descripcion="";
    con=c.conectar();
        try {
            ps=con.prepareStatement(sqlPaso);
            rs=ps.executeQuery();
    
            while(rs.next()){
    
            nombrecampo= rs.getString("nombre_campo");
            numerocampo= rs.getString("numero_campo");
            dato= rs.getString("dato");
            descripcion= rs.getString("descripcion");
    
    
    
             agregarCampoProceso(secuencia,nombrecampo,numerocampo,dato,descripcion);
           
            }
            
            
            
            
            con.close();
    
        } catch (SQLException ex) {
            Logger.getLogger(ProcesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    
    
    return r;
    
    
    
    }
    
      
      
      
          
 public int agregarCampoProceso(int idproceso,String nombrecampo, String numerocampo,String dato,String descripcion){
        int r=0;
    String sql ="insert into proceso_campo (id_proceso,nombre_campo,numero_campo,dato,descripcion)values(?,?,?,?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
   // ps.setString(1,p.getId());
      ps.setInt(1,idproceso);
        ps.setString(2,nombrecampo);
        ps.setString(3,numerocampo);
          ps.setString(4,dato);
            ps.setString(5,descripcion);
    
    
    
    
    
    
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
      
    
    //----------------------------
    
    
    
    
 public int agregarPasoProceso(int idproceso,String nombre, String pasos,String aprobador){
        int r=0;
    String sql ="insert into proceso_paso (id_proceso,nombre_paso_proceso,paso_estado,pasos,fecha,aprobadores)values(?,?,'0',?,sysdate,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
   // ps.setString(1,p.getId());
      ps.setInt(1,idproceso);
        ps.setString(2,nombre+idproceso);
        ps.setString(3,pasos);
          ps.setString(4,aprobador);
          
    
    
    
    
    
    
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
    
        
    String  sqll="UPDATE proceso_paso SET paso_estado = 's'  where id_proceso =? and pasos=1 ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sqll);
    
    ps.setInt(1,idproceso);
 

              

                           
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
    
    
    public Proceso listarId(String id){
    String sql ="select *from proceso where id_proceso="+id;
    Proceso u =new Proceso();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setId_plantilla(rs.getString(2));
         u.setId_usuario(rs.getString(3));
            u.setNombre_proceso(rs.getString(4));
          u.setEstado_proceso(rs.getString(5));
                 u.setFecha(rs.getString(6));
    
    
    
    }
    
    
    }
    catch(Exception e){
    
    
    }
    return u;
    }
    
    
    
    
    
    
    
    public int actualizar (Proceso u){
        int r=0;
    String  sql="update proceso set id_plantilla=?,id_usuario=?,nombre_proceso=?,estado_proceso=?,fecha=? where id_proceso=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
    
    ps.setString(1,u.getId_plantilla());
      ps.setInt(2,Integer.parseInt(u.getId_usuario()));
        ps.setString(3,u.getNombre_proceso());
            ps.setString(4,u.getEstado_proceso());
            
        ps.setString(5,u.getFecha());
         
                     
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
    
    
    
    
    ///------------------
    
      public int actualizaroaso (ProcesoPaso u){
        int r=0;
    String  sql="update proceso_paso set id_proceso=?,nombre_paso_proceso=?,paso_estado=?,pasos=?,fecha=? ,aprobadores=? where id_paso=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
    
    ps.setString(1,u.getId_proceso());
      ps.setInt(2,Integer.parseInt(u.getNombre_paso_proceso()));
        ps.setString(3,u.getPaso_estado());
            ps.setString(4,u.getPasos());
              ps.setString(5,u.getFecha());
                ps.setString(6,u.getAprobadores());
   
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
    
   
    
    
    ///-----------------
    
    
        public void delete(String id)
    {
    
    String sql="delete from proceso where id_proceso=?";
    
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
