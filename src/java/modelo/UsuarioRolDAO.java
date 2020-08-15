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
public class UsuarioRolDAO {
           PreparedStatement ps; 
    ResultSet rs;
    Conexion c= new Conexion ();
    Connection con ;
    
    public List listar (){
    List <UsuarioRol>lista =new ArrayList <>();
   String sql ="select *from usuario_rol";
    
    try{
    con = c.conectar(); 
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while (rs.next()){
        UsuarioRol u= new UsuarioRol();
        u.setIdUsRol(rs.getString(1));
          u.setIdRol(rs.getString(2));
           u.setIdUs(rs.getString(3));
                    
                    lista.add(u);

    }
    
    }
    catch(Exception e){

    }
    return lista;
    }
    
      public int agregar(UsuarioRol p){
        int r=0;
        
    String sql ="insert into usuario_rol (id_usuario_rol,id_rol,id_usuario)values(?,?,?)";
    try{
    con=c.conectar();
    ps=con.prepareStatement(sql);
    ps.setString(1,p.getIdUsRol());
      ps.setString(2,p.getIdRol());
       ps.setString(3,p.getIdUs());

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
    
}
