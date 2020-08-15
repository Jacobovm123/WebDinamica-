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
public class ProcesoPasoDAO {
    
    
       PreparedStatement ps; 
    ResultSet rs;
    Conexion c= new Conexion ();
    Connection con ;
    
    public List listar (){
    List <ProcesoPaso>lista =new ArrayList <>();
   String sql ="select *from proceso_paso";
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        ProcesoPaso u= new ProcesoPaso();
        u.setId(rs.getString(1));
          u.setId_proceso(rs.getString(2));
            u.setNombre_paso_proceso(rs.getString(3));
              u.setPaso_estado(rs.getString(4));
                u.setPasos(rs.getString(5));
                 u.setFecha(rs.getString(6));
                  u.setAprobadores(rs.getString(7));
        
                  
 
 
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
    
      public List listarpasot ( String idusuario){
    List <ProcesoPaso>lista =new ArrayList <>();
   //String sql ="select * from proceso_paso where paso_estado='s'";
      String sqlr="select p.Id_Paso,p.id_proceso,p.nombre_paso_proceso,p.paso_estado,p.pasos,p.fecha, p.aprobadores \n" +
"from proceso_paso p , rol, usuario, usuario_rol\n" +
"where p.aprobadores = rol.nombre_rol and rol.id_rol = usuario_rol.id_rol \n" +
"and usuario_rol.id_usuario=usuario.id_usuario \n" +
"and paso_estado = 's' and usuario.id_usuario="+idusuario;
     
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sqlr);
    rs=ps.executeQuery();
    while (rs.next()){
        ProcesoPaso u= new ProcesoPaso();
        u.setId(rs.getString(1));
          u.setId_proceso(rs.getString(2));
            u.setNombre_paso_proceso(rs.getString(3));
              u.setPaso_estado(rs.getString(4));
                u.setPasos(rs.getString(5));
                 u.setFecha(rs.getString(6));
                  u.setAprobadores(rs.getString(7));
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
    
     
    public int agregar(ProcesoPaso p){
        int r=0;
    String sql ="insert into proceso_paso (id_proceso,nombre_paso_proceso,paso_estado,pasos,fecha,aprobadores)values(?,?,?,?,?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
   // ps.setString(1,p.getId());
      ps.setString(1,p.getId_proceso());
        ps.setString(2,p.getNombre_paso_proceso());
        ps.setString(3,p.getPaso_estado());
          ps.setString(4,p.getPasos());
           ps.setString(5,p.getFecha());
            ps.setString(6,p.getAprobadores());
           
    
    
    
    
   r= ps.executeUpdate();
   ps.close();
   con.close();
   
    if(r==1){
    r=1;
    }else{
    r=0;
    
    }
    }
    catch(Exception e){
    
        System.out.println("Error proceso paso "+e);
    }
    return r;
    }
    
    
    public ProcesoPaso listarId(String id){
    String sql ="select *from proceso_paso where id_paso="+id;
    ProcesoPaso  u =new ProcesoPaso
        ();
    try {
    con=c.conectar();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    
    u.setId(rs.getString(1));
       u.setId_proceso(rs.getString(2));
          u.setNombre_paso_proceso(rs.getString(3));
             u.setPaso_estado(rs.getString(4));
                u.setPasos(rs.getString(5));
                  u.setFecha(rs.getString(6));
                    u.setAprobadores(rs.getString(7));
                  
    
    
    }
    
    
    }
    catch(Exception e){
    
    
    }
    return u;
    }
    
    public int actualizar (ProcesoPaso u){
        int r=0;
    String  sql="update proceso_paso set id_proceso=?,nombre_paso_proceso=?,paso_estado=?,pasos=?,fecha=?,aprobadores=? where id_paso=? ";
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);
    
    ps.setString(1,u.getId_proceso());
        ps.setString(2,u.getNombre_paso_proceso());
            ps.setString(3,u.getPaso_estado());
                ps.setString(4,u.getPasos());
                     ps.setString(5,u.getFecha());
                           ps.setString(6,u.getAprobadores());
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
    
    
//-----------------------------iicio
    
    
    
      public int actualizar2 (String idproc, String idpas){
        int r=0;
    String  sql="update proceso_paso set paso_estado = 'rechazado' where id_proceso="+idproc;
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql);

            
    r=ps.executeUpdate();
    
    if(r==1){
    
    r=1;
    
    }else{
    r=0;

    }
    }
    catch(Exception e){
            
            }
    
    
    //inicio
   String  sql1="update proceso set  estado_proceso = 'rechazado'  where id_proceso=" +idproc;
    try{   
        con=c.conectar();
    ps=con.prepareStatement(sql1);

            
    r=ps.executeUpdate();
    
    if(r==1){
    
    r=1;
    
    }else{
    r=0;

    }
    }
    catch(Exception e){
            
            }


    //fin
    
    
    
    return r;
    }
//------------------fin 
    
    
    
    public void delete(String id)
    {
    
    String sql="delete from proceso_paso where id_paso=?";
    
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
