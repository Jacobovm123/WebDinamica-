<%-- 
    Document   : ListarPlantilla2
    Created on : 25/09/2019, 05:20:57 AM
    Author     : jacob
--%>


<%@page import="modelo.PlantillaPaso"%>
<%@page import="modelo.PlantillaPasoDAO"%>
<%@page import="modelo.PlantillaCampo"%>
<%@page import="modelo.PlantillaCampoDAO"%>
<%@page import="modelo.Plantilla"%>
<%@page import="modelo.PlantillaDAO"%>
<%@page import="modelo.Plantilla2"%>
<%@page import="java.util.List"%>
<%@page import="modelo.PlantillaDAO2"%>
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
        <!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="campo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">campos de la plantilla</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
    
        
        
              <div class="form-group">
        
               <form align="left"  action="ControladorPlantillaCampo" method="POST">
             
                <tr>
                    
         
               <br>
               ID PLANTILLA:
             
               <br>
              <%
                String plantilla = request.getParameter("dropPlantilla");
                out.println(plantilla);
                

          %>
                    
   
                <br>
                campos de la plantilla :
               <select  class="form-control" id="dropcampo" name="dropcampo">
                         <br>
                        <%
                            
                            PlantillaCampoDAO dao = new PlantillaCampoDAO();
                            
                            List<PlantillaCampo>datos=dao.listar2(plantilla);
                            for(int i=0; i<datos.size(); i++){
                            out.print("<option value="+datos.get(i).getId()+">"+
                            datos.get(i).getNombre_campo()
                            +"</option>");
                            }
                        %>
                        <br>
                    
                </select>
               
               
               <br>
                
                   tipo de dato :
               <select  class="form-control" id="dropcampo" name="dropcampo">
                         <br>
                        <%
                     
                            for(int i=0; i<datos.size(); i++){
                            out.print("<option value="+datos.get(i).getId()+">"+
                            datos.get(i).getDato()
                            +"</option>");
                            }
                        %>
                        <br>
                    
                </select>
               
               
               <br>
              
             descripcion :
               <select  class="form-control" id="dropcampo" name="dropcampo">
                         <br>
                        <%
                     
                            for(int i=0; i<datos.size(); i++){
                            out.print("<option value="+datos.get(i).getId()+">"+
                            datos.get(i).getDescripcion()
                            +"</option>");
                            }
                        %>
                        <br>
                    
                </select>
     <a class="btn btn-primary"  href="ListarPlantillaCampo.jsp">Listar todos los campos de la plantillas </a> <td>
            </form>
               
        </div>
        
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
     
      </div>
    </div>
  </div>
</div>
      
      <!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="pasos" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
        
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">pasos de la plantilla </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
        
 <div class="form-group">
        
               <form align="left"  action="ControladorPlantillaPaso" method="POST">
             
                <tr>
                    
         
               <br>
               ID PLANTILLA:
             
               <br>
              <%
                String plantillav = request.getParameter("dropPlantilla");
                out.println(plantillav);
                

          %>
                    
   
                <br>
               nombre paso plantilla :
               <select  class="form-control" id="dropcampo" name="dropcampo">
                         <br>
                        <%
                            
                            PlantillaPasoDAO daov = new PlantillaPasoDAO();
                            
                            List<PlantillaPaso>datosv=daov.listar2(plantillav);
                            for(int i=0; i<datosv.size(); i++){
                            out.print("<option value="+datosv.get(i).getId()+">"+
                            datosv.get(i).getNombre()
                            +"</option>");
                            }
                        %>
                        <br>
                    
                </select>
                    <br>
                numero de paso de la plantilla :
               <select  class="form-control" id="dropcampo" name="dropcampo">
                         <br>
                        <%
                            
                   
                            for(int i=0; i<datosv.size(); i++){
                            out.print("<option value="+datosv.get(i).getId()+">"+
                            datosv.get(i).getNumero_pasos()
                            +"</option>");
                            }
                        %>
                        <br>
                    
                </select>
                                <br>
                aprobadores :
               <select  class="form-control" id="dropcampo" name="dropcampo">
                         <br>
                        <%
                            
                   
                            for(int i=0; i<datosv.size(); i++){
                            out.print("<option value="+datosv.get(i).getId()+">"+
                            datosv.get(i).getAprobadores()
                            +"</option>");
                            }
                        %>
                        <br>
                    
                </select>
               
         
                          <a class="btn btn-primary"  href="ListarPlantillaPaso.jsp">Listar todos los pasos de las plantillas </a> <td>
         

            </form>
               
        </div>
        
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar </button>

      </div>
        
    </div>
  </div>
</div>
      
      
    
    

  
  
  
  
    <center>
              <div class="form-group">
            <h3> Lista de plantilla </h3>
            
         
                        <form action="ControladorPlantillaPaso" method="POST">
                 
                 
                  <select id="dropPlantilla" name="dropPlantilla">
                         <br>
                        <%
                            PlantillaDAO dao222 = new PlantillaDAO();
                            List<Plantilla>datos222=dao222.listar();
                            for(int i=0; i<datos222.size(); i++){
                            out.print("<option value="+datos222.get(i).getId()+">"+
                            datos222.get(i).getNombre()
                            +"</option>");
                            }
                        %>
                        <br>
                    
                </select>
                        
                          <input  class="btn btn-success" type="submit" name="accion" value="ver" >
                   
                </form>   
                        
   
             <form action="ControladorPlantilla2" method="POST">
 
                                      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#campo">
 ver campo
</button>
                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#pasos">
  ver los pasos
</button>
                 
                       <a class="btn btn-primary"  href="MenuAdmin.jsp"> Menu principal </a> <td>
   
                <input  class="btn btn-success" type="submit" name="accion" value="Listar" >
                   <input  class="btn btn-primary" type="submit" name="accion"  value="Nuevo">
                    
                </form>
                       
            </div>
        
          
                
            <div>
            <table  class="table table-striped" >
                <thead>
                    
                    <tr>
                  
                        <th>ID</th>
                   
                  
                          <th>NOMBRE</th>
        
                            <th>DESCRIPCION</th>
                    
                             
                        
                        
                    </tr>
                </thead>   
                <tbody>
                       
                    
                    <%
                    PlantillaDAO2 dao1 = new PlantillaDAO2();
                    
                    List<Plantilla2>datos1=dao1.listar();
                    
for (int i = 0; i < datos1.size(); i++) {
       
        %>
                
        <tr>
            
                <td><%=datos1.get(i).getId() %></td>
            
                <td><%=datos1.get(i).getNombre()%></td>
            
                <td><%=datos1.get(i).getDescripcion()%></td>
          
                 
                <td>
                
                    <form  action="ControladorPlantilla2" method="POST"  >
                        
                        
                       
                        
                        
                              <input type="hidden"  name="id" id="id"  value="<%=datos1.get(i).getId() %>" >
                              
                              
                              
                           
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