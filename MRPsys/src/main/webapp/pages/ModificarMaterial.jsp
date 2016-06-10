<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Clases.Material" %>
<%@page import="java.util.List" %>
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
                  <h1 class="page-header" style="text-transform:uppercase; font-size:24px;">Modificar Material</h1>
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
                              <form method="POST" action="${pageContext.request.contextPath}/pages/ModificarMaterial">
                                 <div class="form-group">
                                 <%
                                    	Material m = (Material)request.getAttribute("material");
                                  %>
                                    <label>Referencia</label>
                                    <input type="hidden" name="referencia" value="<%=m.getReferencia() %>">
                                    <input class="form-control" id="disabledInput" disabled="" value="<%=m.getReferencia()%>" type="text">
                                 </div>
                                 <div class="form-group">
                                    <label>Nombre</label>
                                    <input class="form-control" name="nombre" value="<%=m.getNombre() %>" type="text" autofocus>
                                 </div>
                                 <div class="form-group">
                                    <label>Idioma</label>
                                    <input class="form-control" name="idioma" value="<%=m.getIdioma() %>" type="text" autofocus>
                                 </div>
                                 <div class="form-group">
                                    <label>Elemento</label>
                                    <input class="form-control" name="elemento" value="<%=m.getElemento() %>" type="text" autofocus>
                                 </div>
                                 <div class="form-group">
                                    <label>Lead time</label>
                                    <input class="form-control" name="lead" value="<%=m.getLead() %>" type="text" autofocus>
                                 </div>
                                 <div class="form-group">
                                    <label>Stock virtual</label>
                                    <input class="form-control" name="virtual" value="<%=m.getVirtual() %>" type="text" autofocus>
                                 </div>
                                 <div class="form-group">
                                    <label>Stock seguridad</label>
                                    <input class="form-control" name="seguridad" value="<%=m.getSeguridad() %>" type="text" autofocus>
                                 </div>
                                 <button type="submit" class="btn btn-success">Modificar</button>
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