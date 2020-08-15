<%-- 
    Document   : ListarCategoria
    Created on : 21/08/2019, 12:40:31 AM
    Author     : jacob
--%>
<%@page import="modelo.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="modelo.CategoriaDAO"%>
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
        
        
        
        
 
       <a href="index.jsp">Listar categoria </a> 
        
      
    <center>
        <div>
            <h3>listado de categoria  </h3>
             <form action="ControladorCategoria" method="POST">
                <input class="btn btn-success"  type="submit" name="accion" value="Listar" >
                   <input  class="btn btn-primary" type="submit" name="accion"  value="Nuevo">
                </form>
            
            </div>
                
            <div lass="form-group">
            <table class="table table-striped"   >
                <thead>
                    
                    <tr>
                  
                        <th>ID</th>
                   
                         <th>CATEGORIA</th>
                         <th>DESCRIPCION</th>
                     
                        
                        
                    </tr>
                </thead>   
                <tbody>
                       
                    
                    
                    <%
                    CategoriaDAO dao = new CategoriaDAO();
                    
                    List<Categoria>datos=dao.listar();
for (int i = 0; i < datos.size(); i++) {
       
        %>
                
        <tr>
            
                <td><%=datos.get(i).getId() %></td>
                <td><%=datos.get(i).getCategoria() %></td> 
                    <td><%=datos.get(i).getDescripcion() %></td> 
                
                       <td>
                                         <form  action="ControladorCategoria" method="POST"  >
                                            
                              <input type="hidden"  name="id"   value="<%=datos.get(i).getId() %>" >
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