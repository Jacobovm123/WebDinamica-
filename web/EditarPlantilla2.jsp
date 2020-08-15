<%-- 
    Document   : EditarPlantilla2
    Created on : 25/09/2019, 05:24:29 AM
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
              
                  <h1> editar plantilla </h1>              
          </div>
                
     
                 
        <div class="form-group">
        
            <form align="left"  action="ControladorPlantilla2" method="POST">
             
                <tr>
                    
                <br>
                 ID:
              
                 <input class="form-control" placeholder="id "  type="text" name="txtid" value="${plantilla.getId()}">
               <br>
               ID CATEGORIA:
               <input   class="form-control" placeholder="id categoria"  type="text" name="txtidcategoria"  value="${plantilla.getIdcategoria()} ">
               <br>
               NOMBRE:
               <input class="form-control" placeholder="nombre"  type="text" name="txtnombre"  value="${plantilla.getNombre()}">
               <br>
               FECHA:
               <input class="form-control" placeholder="fecha"  type="date" name="txtfecha"  value="${plantilla.getFecha()} " >
               <br>
               DESCRIPCION:
               <input class="form-control" placeholder="descripcion"  type="text" name="txtdescripcion" value="${plantilla.getDescripcion()}" >
               <br>
               INICIARLAS:
               <input class="form-control" placeholder="iniciarlas"  type="text" name="txtiniciarlas" value="${plantilla.getIniciarlas()} ">
               
            
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