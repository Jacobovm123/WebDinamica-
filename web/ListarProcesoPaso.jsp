<%-- 
    Document   : ListarProcesoPaso
    Created on : 17/10/2019, 10:38:21 AM
    Author     : jacob
--%>



<%@page import="modelo.ProcesoPaso"%>
<%@page import="modelo.ProcesoPasoDAO"%>
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
        
        
        
        
 

        
      
    <center>
        <div>
            <h3>listado proceso paso </h3>
             <form action="ControladorProcesoPaso" method="POST">
                    <a class="btn btn-primary"  href="MenuAdmin.jsp"> Menu principal </a> <td>
       
                <input class="btn btn-success"  type="submit" name="accion" value="Listar" >
                   <input  class="btn btn-primary" type="submit" name="accion"  value="Nuevo">
                </form>
            
            </div>
                
            <div lass="form-group">
            <table class="table table-striped"   >
                <thead>
                    
                    <tr>
                      <th>ID PASO</th>
                        <th>ID PROCESO</th>
                   
                         <th>NOMBRE PASO PROCESO </th>
                             <th> PASO ESTADO</th>
                             <th> PASOS</th>
                                     <th>FECHA </th>
                         
                                 <th>APROBADORES </th>
                    
                         
                         
                        
                        
                    </tr>
                </thead>   
                <tbody>
                       
                    
                    <%
                    ProcesoPasoDAO dao = new ProcesoPasoDAO();
                    
                    List<ProcesoPaso>datos=dao.listar();
                    
for (int i = 0; i < datos.size(); i++) {
       
        %>
                
        <tr>
            
                <td><%=datos.get(i).getId() %></td>
                <td><%=datos.get(i).getId_proceso()%></td>
                <td><%=datos.get(i).getNombre_paso_proceso()%></td> 
                <td><%=datos.get(i).getPaso_estado()%></td>
                <td><%=datos.get(i).getPasos()%></td>
           
                      <td><%=datos.get(i).getFecha()%></td>
                            <td><%=datos.get(i).getAprobadores()%></td>
                          
                
                       <td>
                                         <form  action="ControladorProcesoPaso" method="POST"  >
                            <input type="hidden"  name="id"  id="id" value="<%=datos.get(i).getId() %>" >
                              <input  class="btn btn-success" type="submit"  name="accion" value="Editar" >
                                <input  class="btn btn-danger" type="submit" name="accion"  value="Delete">
                    
                    
                    
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