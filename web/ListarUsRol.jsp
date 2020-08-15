<%-- 
    Document   : ListarUsRol
    Created on : 20/08/2019, 12:27:29 AM
    Author     : jacob
--%>

<%@page import="modelo.UsuarioRol"%>
<%@page import="java.util.List"%>
<%@page import="modelo.UsuarioRolDAO"%>
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
       
        
        
 
        <a class="btn btn-primary" href="index.jsp"> index  </a> 
        
      
    <center>
        
        
          <div class="page-header">
              
                  <h1> lista de usuario rol</h1>              
          </div>
              
        <div   class="">
            <h3></h3>
             <form action="ControladorUsRol" method="POST">
                 <input class="btn btn-success" type="submit" name="accion" value="Listar" >
                 <input class="btn btn-primary" type="submit" name="accion"  value="Nuevo">
                </form>
            
            </div>
                
            <div>
                <table class="table table-striped">
                <thead>
                    
                    <tr>
                  
                        <th>ID USUARIO ROL</th>
                   
                         <th>ID ROL</th>
                           <th>ID USUARIO</th>
                      
                        
                        
                    </tr>
                </thead>   
                <tbody>
                       
                    
                    <%
                    UsuarioRolDAO dao = new UsuarioRolDAO();
                    
                    List<UsuarioRol>datos=dao.listar();
                    
for (int i = 0; i < datos.size(); i++) {
       
        %>
                
        <tr>
            
                <td><%=datos.get(i).getIdUsRol() %></td>
                <td><%=datos.get(i).getIdRol() %></td> 
                 <td><%=datos.get(i).getIdUs() %></td> 
              
            
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