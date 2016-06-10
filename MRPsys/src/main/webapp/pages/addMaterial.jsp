<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>MRPsys main page</title>
   </head>
   <body>
      <div id="wrapper">
         <jsp:include page="/tools/navBar.jsp"/>
         <div id="page-wrapper">
            <div class="row">
               <div class="col-lg-12">
                  <h1 class="page-header" style="text-transform:uppercase; font-size:24px;">Añadir Material</h1>
               </div>
               <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
               <div class="col-lg-12">
                  <div class="panel panel-default">
                     <div class="panel-heading">Especificaciones del material</div>
                     <div class="panel-body">
                        <div class="row">
                           <div class="col-lg-6">
                              <form method="POST" action="${pageContext.request.contextPath}/pages/AddMaterial">
                                 <div class="form-group">
                                    <label>Referencia</label>
                                    <input class="form-control" placeholder="Referencia" name="referencia" type="text" autofocus>
                                    <p class="help-block">Ej: QGA001UU</p>
                                 </div>
                                 <div class="form-group">
                                    <label>Nombre</label>
                                    <input class="form-control" placeholder="Nombre" name="nombre" type="text" autofocus>
                                    <p class="help-block">Ej: QGA</p>
                                 </div>
                                 <div class="form-group">
                                    <label>Idioma</label>
                                    <input class="form-control" placeholder="Idioma" name="idioma" type="text" autofocus>
                                    <p class="help-block">Ej: UU</p>
                                 </div>
                                 <div class="form-group">
                                    <label>Elemento</label>
                                    <input class="form-control" placeholder="Elemento" name="elemento" type="text" autofocus>
                                    <p class="help-block">Ej: Quick Guide</p>
                                 </div>
                                 <div class="form-group">
                                    <label>Lead time</label>
                                    <input class="form-control" placeholder="Tiempo en semanas" name="lead" type="text" autofocus>
                                    <p class="help-block">Ej: 5</p>
                                 </div>
                                 <div class="form-group">
                                    <label>Stock virtual</label>
                                    <input class="form-control" placeholder="Unidades totales en almacén" name="virtual" type="text" autofocus>
                                    <p class="help-block">Ej: 500</p>
                                 </div>
                                 <div class="form-group">
                                    <label>Stock seguridad</label>
                                    <input class="form-control" placeholder="Unidades que no se pueden consumir" name="seguridad" type="text" autofocus>
                                    <p class="help-block">Ej: 100</p>
                                 </div>
                                 <button type="submit" class="btn btn-success">Añadir</button>
                                 <button type="reset" class="btn btn-primary">Reset</button>
                              </form>
                           </div>
                           <!-- /.col-lg-6 (nested) -->
                           <!-- /.col-lg-6 (nested) -->
                        </div>
                        <!-- /.row (nested) -->
                     </div>
                     <!-- /.panel-body -->
                  </div>
                  <!-- /.panel -->
               </div>
               <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
         </div>
         <!-- /#page-wrapper -->
      </div>
      <!-- /#wrapper -->
   </body>
</html>