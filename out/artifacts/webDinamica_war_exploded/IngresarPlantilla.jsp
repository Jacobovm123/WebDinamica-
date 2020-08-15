<%-- 
    Document   : IngresarPlantilla
    Created on : 22/08/2019, 03:14:04 PM
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
              
                  <h1> ingresar plantilla </h1>              
          </div>
              
              
        <div class="form-group">
        
            <form align="left" action="ControladorPlantilla" method="POST">
             
                <tr>
                    
                <br>
                 ID PLANTILLA:
              
               <input   class="form-control" placeholder="id plantilla"  type="text" name="txtid">
               <br>
               ID CATEGORIA:
               <input   class="form-control" placeholder="nombe rol " type="text" name="txtidcategoria">
                     <br>
               NOMBRE:
               <input   class="form-control" placeholder="nombe " type="text" name="txtnombre">
        
                    <br>
               FECHA:
               <input   class="form-control" placeholder="fecha " type="date" name="txtfecha">
        
               
                      <br>
               DESCRIPCION:
               <input   class="form-control" placeholder="descripcion " type="text" name="txtdescripcion">
        
               
               
               
               <input  align="center" class="btn btn-success"  type="submit" name="accion"  value="Guardar">
               </tr>
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