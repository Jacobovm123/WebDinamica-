<%-- 
    Document   : procesopaso
    Created on : 29/10/2019, 08:07:15 PM
    Author     : jacob
--%>




<%@page import="modelo.CampoComportamiento"%>
<%@page import="modelo.CampoComportamientoDAO"%>
<%@page import="modelo.Plantilla"%>
<%@page import="modelo.PlantillaDAO"%>
<%@page import="modelo.PasoCampoComportamiento"%>
<%@page import="java.util.List"%>
<%@page import="modelo.PasoCampoComportamientoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
    <body>
        
        <div>
            
                <form  action="ControladorProcesoPaso" method="POST"  >
                          
                    
                    <center>
                     
    
             <%
                 String ids = request.getParameter("idpas");
                 String idf = request.getParameter("idpro");
             %>
             <input type="hidden" name="idproc" id="idproc" value=<%out.write(ids);%>>
             <input type="hidden" name="idpaso" id="idpaso" value=<%out.write(idf);%>>
              <input  class="btn btn-primary" type="submit" name="accion"  value="Rechazar">
                <input  class="btn btn-primary" type="submit" name="accion"  value="Redireccionamiento">
                <input  class="btn btn-primary" type="submit" name="accion"  value="Aprobar">
    </center>    
             
             
                </form>  
            
        </div>
        
        <br>   
    <center>
        
         <a class="btn btn-primary"  href="MenuAdmin.jsp"> Menu principal </a> <td>   
    </center>   
                        
                       
                        
                    
                        
                         
            <form align="left"  action="ControladorCampoComportamientoup" method="POST">
             
                <tr>
                    
                <br>
                
                  <div class="col-xs-2">
                 ID PASO COMPORTAMIENTO:
              
                 <input  placeholder="id paso comportamiento "  type="text" name="txtid" value="${campocomportamiento.getId()}">
               <br>
           
               DESCRIPCION:
               <input  placeholder="descripcion"  type="text" name="txtdescripcion" value="${campocomportamiento.getDescripcion()}" >
                    </div>      
           
               <br>
           
               <input class="btn btn-success" type="submit" name="accion"  value="Actualizar1">
                
            </form>
               
        <%
            
String idpro = request.getParameter("idpro");

            
            %>
            
            
        
 
      
               
                  
    
            
            
           
    <center>
      
                
            <div class="form-group">
            <table class="table table-striped"   >
                <thead>
                    
                    <tr>
                      <th>ID PASO COMPORTAMIENTO</th>
                     
                         
                             <th> NOMBRE CAMPO </th>
                                    
                         
                         
                        
                        
                    </tr>
                </thead>   
                <tbody>
                       
                    
                    <%
                    CampoComportamientoDAO dao = new CampoComportamientoDAO();
                    
                    List<CampoComportamiento>datos=dao.listarp(idpro);
                    
for (int i = 0; i < datos.size(); i++) {
       
        %>
                
        <tr>
            
                <td><%=datos.get(i).getId() %></td>
            
                <td><%=datos.get(i).getNombre_campo()%></td>
                
                
                
              
            
        
                       <td>
                           
                                         <form  action="ControladorCampoComportamientoup" method="POST"  >
                            <input type="hidden"  name="id"  id="id" value="<%=datos.get(i).getId() %>" >
                             
                            <input type="hidden"  name="idpro"  id="idpro" value="<%=idf%>" >
                            <input type="hidden"  name="idpas"  id="idpas" value="<%=ids %>" >
                            
                            
                        <input  class="btn btn-success" type="submit"  name="accion" value="Editar1" >
                    
                   
                </form>
                
              
                </tr>           
                
        <%
    }


                    %>
                    
                    

                </tbody>
                
            </table>
            
            
        </div>        
        
        
    </center>
        
    </body>
    
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>