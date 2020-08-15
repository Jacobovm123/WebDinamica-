<%-- 
    Document   : EditarCampoComportamiento
    Created on : 9/09/2019, 03:08:01 PM
    Author     : jacob
--%>



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
      
          
              <div class="page-header">
              
                  <h1> editar campo comportamiento </h1>              
          </div>
                
     
                 
        <div class="form-group">
        
            <form align="left"  action="ControladorCampoComportamientoup" method="POST">
             
                <tr>
                    
                <br>
                 ID PASO COMPORTAMIENTO:
              
                 <input class="form-control" placeholder="id paso comportamiento "  type="text" name="txtid" value="${campocomportamiento.getId()}">
               <br>
               ID CAMPO PROCESO:
               <input   class="form-control" placeholder="id camp proceso"  type="text" name="txtidcampoproceso"  value="${campocomportamiento.getId_campo_proceso()} ">
               <br>
              ID PASO:
               <input class="form-control" placeholder="id paso"  type="text" name="txtidpaso"  value="${campocomportamiento.getId_paso()}">
               <br>
              NOMBRE CAMPO:
               <input class="form-control" placeholder="nombre campo"  type="text" name="txtnombrecampo"  value="${campocomportamiento.getNombre_campo()} " >
               <br>
               NUMERO CAMPO:
               <input class="form-control" placeholder="numero campo"  type="text" name="txtnumerocampo" value="${campocomportamiento.getNumero_campo()}" >
                     <br>
               DATO:
               <input class="form-control" placeholder="dato"  type="text" name="txtdato" value="${campocomportamiento.getDato()}" >
                             <br>
               DESCRIPCION:
               <input class="form-control" placeholder="descripcion"  type="text" name="txtdescripcion" value="${campocomportamiento.getDescripcion()}" >
                        
           
                   
           
               <input class="btn btn-success" type="submit" name="accion"  value="Actualizar">
                
            </form>
                
        </div>
        
    </center>

    </body>
    
    
 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>