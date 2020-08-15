

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
              
                  <h1> editar proceso paso </h1>              
          </div>
                
     
                 
        <div class="form-group">
        
            <form align="left"  action="ControladorProcesoPaso" method="POST">
             
                <tr>
                    
                <br>
                 ID PASO :
              
                 <input class="form-control" placeholder="id paso  "  type="text" name="txtid" value="${procesopaso.getId()}">
               <br>
               ID PROCESO:
               <input   class="form-control" placeholder="id proceso"  type="text" name="txtidproceso"  value="${procesopaso.getId_proceso()} ">
               <br>
              NOMBRE PASO PROCESO:
               <input class="form-control" placeholder="nombre paso proceso"  type="text" name="txtnombrepasoproceso"  value="${procesopaso.getNombre_paso_proceso()}">
               <br>
              PASO ESTADO:
               <input class="form-control" placeholder="paso estado"  type="text" name="txtpasoestado"  value="${procesopaso.getPaso_estado()} " >
               <br>
               PASOS:
               <input class="form-control" placeholder="pasos"  type="text" name="txtpasos" value="${procesopaso.getPasos()}" >
                     <br>
               FECHA:
               <input class="form-control" placeholder="fecha"  type="date" name="txtfecha" value="${procesopaso.getFecha()}" >
                             <br>
               APROBADORES:
               <input class="form-control" placeholder="aprobadores"  type="text" name="txtaprobadores" value="${procesopaso.getAprobadores()}" >
         
                   
           
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