<%-- 
    Document   : ListarPasoCampoComportamiento
    Created on : 5/09/2019, 04:35:36 PM
    Author     : jacob
--%>

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
            <h3>listado paso campo comportamiento </h3>
                  <a class="btn btn-primary"  href="MenuAdmin.jsp"> Menu principal </a> <td>
       
      
             <form action="ControladorCampoComportamiento" method="POST">
                     <select id="dropPlantilla" name="dropPlantilla">
                         <br>
                        <%
                            PlantillaDAO dao2 = new PlantillaDAO();
                            List<Plantilla>datos2=dao2.listar();
                            for(int i=0; i<datos2.size(); i++){
                            out.print("<option value="+datos2.get(i).getId()+">"+
                            datos2.get(i).getNombre()
                            +"</option>");
                            }
                        %>
                        <br>
                    
                </select>
                <input class="btn btn-success"  type="submit" name="accion" value="Listar" >
                   <input  class="btn btn-primary" type="submit" name="accion"  value="Nuevo">
                </form>
            
            </div>
                
            <div lass="form-group">
            <table class="table table-striped"   >
                <thead>
                    
                    <tr>
                      <th>ID PASO COMPORTAMIENTO</th>
                        <th>ID PLANTILLA PASO</th>
                   
                         <th>ID  PLANTILLA CAMPO </th>
                         
                             <th> NOMBRE CAMPO </th>
                                     <th>NUMERO DE CAMPO  </th>
                         
                                 <th>DATO </th>
                                 
                                 <th>DESCRIPCION </th>
                             
                         
                         
                        
                        
                    </tr>
                </thead>   
                <tbody>
                       
                    
                    <%
                    PasoCampoComportamientoDAO dao = new PasoCampoComportamientoDAO();
                    
                    List<PasoCampoComportamiento>datos=dao.listar();
                    
for (int i = 0; i < datos.size(); i++) {
       
        %>
                
        <tr>
            
                <td><%=datos.get(i).getId() %></td>
                <td><%=datos.get(i).getId_plantilla_paso()%></td>
                <td><%=datos.get(i).getId_plantilla_campo()%></td> 
                <td><%=datos.get(i).getNombre_campo()%></td>
                <td><%=datos.get(i).getNumero_campo()%></td>
           
                      <td><%=datos.get(i).getDato()%></td>
                            <td><%=datos.get(i).getDescripcion()%></td>
                            
                
                       <td>
                                         <form  action="ControladorCampoComportamiento" method="POST"  >
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