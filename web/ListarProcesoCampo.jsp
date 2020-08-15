<%-- 
    Document   : ListarProcesoCampo
    Created on : 16/10/2019, 05:06:31 PM
    Author     : jacob
--%>


<%@page import="modelo.ProcesoCampo"%>
<%@page import="modelo.ProcesoCampDAO"%>
<%@page import="modelo.Plantilla"%>
<%@page import="modelo.PlantillaDAO"%>


<%@page import="java.util.List"%>


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
  <body  >
        
   
      
    <center>
              <div class="form-group">
            <h3> Lista de proceso campo </h3>
             <form action="ControladorProcesoCampo" method="POST">
                   <a class="btn btn-primary"  href="MenuAdmin.jsp"> Menu principal </a> <td>
       
                <input  class="btn btn-success" type="submit" name="accion" value="Listar" >
                   <input  class="btn btn-primary" type="submit" name="accion"  value="Nuevo">
                </form>
            
            </div>
        
          
                
            <div>
            <table  class="table table-striped" >
                <thead>
                    
                    <tr>
                  
                        <th>ID CAMPO PROCESO</th>
                   
                         <th >ID PROCESO</th>
                          <th>NOMBRE CAMPO</th>
                           <th>NUMERO CAMPO</th>
                            <th>DATO</th>
                             <th>DESCRIPCION</th>
                            
                        
                        
                    </tr>
                </thead>   
                <tbody>
                       
                    
                    <%
                    ProcesoCampDAO dao = new ProcesoCampDAO();
                    
                    List<ProcesoCampo>datos=dao.listar();
                    
for (int i = 0; i < datos.size(); i++) {
       
        %>
                
        <tr>
            
                <td><%=datos.get(i).getId() %></td>
                <td><%=datos.get(i).getIdproceso()%></td> 
                <td><%=datos.get(i).getNombrecampo()%></td>
                <td><%=datos.get(i).getNumerocampo()%></td>
                
                <td><%=datos.get(i).getDato()%></td>
                <td><%=datos.get(i).getDescripcion()%></td> 
                <td>
                
                    <form  action="ControladorProcesoCampo" method="POST"  >
                              <input type="hidden"  name="id" id="id"  value="<%=datos.get(i).getId() %>" >
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