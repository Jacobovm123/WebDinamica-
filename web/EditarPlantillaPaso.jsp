
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
              
                  <h1> editar plantilla paso </h1>              
          </div>
                
     
                 
        <div class="form-group">
        
            <form align="left"  action="ControladorPlantillaPaso" method="POST">
             
                <tr>
                    
                <br>
                 ID:
              
                 <input class="form-control" placeholder="id "  type="text" name="txtid" value="${plantillapaso.getId()}">
               <br>
               ID PLANTILLA:
               <input   class="form-control" placeholder="id plantilla"  type="text" name="txtidplantilla"  value="${plantillapaso.getId_plantilla()} ">
               <br>
              NUMERO DE PASOS :
               <input class="form-control" placeholder="numeropasoc"  type="text" name="txtnumeropaso"  value="${plantillapaso.getNumero_pasos()}">
               <br>
              NOMBRE:
               <input class="form-control" placeholder="nombre"  type="text" name="txtnombre"  value="${plantillapaso.getNombre()} " >
               <br>
               APROBADORES:
               <input class="form-control" placeholder="aprobadores"  type="text" name="txtaprobadores" value="${plantillapaso.getAprobadores()}" >
                        
           
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