<%-- 
    Document   : EditarProcesoCampo
    Created on : 16/10/2019, 05:06:15 PM
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
              
                  <h1> editar proceso campo </h1>              
          </div>
                
     
                 
        <div class="form-group">
        
            <form align="left"  action="ControladorProcesoCampo" method="POST">
             
                <tr>
                    
                <br>
                 ID CAMPO PROCESO:
              
               <input class="form-control" placeholder="id campo proceso "  type="text" name="txtid" value="${procesocampo.getId()}">
               <br>
               ID PROCESO:
               <input   class="form-control" placeholder="idproceso"  type="text" name="txtidproceso"  value="${procesocampo.getIdproceso()} ">
               <br>
               NOMBRE CAMPO:
               <input class="form-control" placeholder="nombrecampo"  type="text" name="txtnombrecampo"  value="${procesocampo.getNombrecampo()}">
               <br>
               NUMERO CAMPO:
               <input class="form-control" placeholder="numerocampo"  type="text" name="txtnumerocampo"  value="${procesocampo.getNumerocampo()} " >
               <br>
               DATO:
               <input class="form-control" placeholder="dato"  type="text" name="txtdato" value="${procesocampo.getDato()}" >
                     <br>
              DESCRIPCION:
               <input class="form-control" placeholder="descripcion"  type="text" name="txtdescripcion" value="${procesocampo.getDescripcion()}" >
                    <br>
     
                   
           
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