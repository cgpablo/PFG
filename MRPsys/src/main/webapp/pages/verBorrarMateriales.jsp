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
                  <h1 class="page-header">Borrar Material</h1>
               </div>
               <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <!-- /.row -->
            <!-- /.row -->
            <div class="row">
               <!-- /.col-lg-6 -->
              <div class="col-lg-6" style="width:832px;">
                  <div class="panel panel-default" style="width:832px;">
                     <div class="panel-heading" style="width:830px;">Lista de materiales</div>
                     <!-- /.panel-heading -->
                     <div class="panel-body" style="width:832px;">
                        <div class="table-responsive table-bordered" style="width:800px;">
                           <table class="table">
                              <thead>
                                 <tr>
                                    <th>Referencia</th>
                                    <th>Nombre</th>
                                    <th>Idioma</th>
                                    <th>Elemento</th>
                                    <th>Lead Time</th>
                                    <th>Stock Real</th>
                                    <th>Stock Seguridad</th>
                                    <th>Stock Virtual</th>
                                    <th>Acción</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <%
                                    List <Material> materiales = (List)request.getAttribute("materiales");
                                    Material m;
                                    for(int i=0; i<materiales.size();i++) {
                                    m = materiales.get(i);
                                 %>
                                 <tr>
                                    <td><%=m.getReferencia() %></td>
                                    <td><%=m.getNombre() %></td>
                                    <td><%=m.getIdioma()%></td>
                                    <td><%=m.getElemento()%></td>
                                    <td><%=m.getLead()%></td>
                                    <td><%=m.getReal()%></td>
                                    <td><%=m.getSeguridad()%></td>
                                    <td><%=m.getVirtual()%></td>
                                    <td>
										<form method="POST" action="${pageContext.request.contextPath}/pages/BorrarMaterial">
											<input type="hidden" name="referencia" value="<%=m.getReferencia()%>">
											<button type="submit" class="btn btn-danger" name="borrar">Borrar</button>					
										</form>
									</td>
                                 </tr>
                                 <%
                                    }
                                    %>
                              </tbody>
                           </table>
                        </div>
                        <!-- /.table-responsive -->
                     </div>
                     <!-- /.panel-body -->
                  </div>
                  <!-- /.panel -->
               </div>
               <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
            <!-- /.row -->
         </div>
         <!-- /#page-wrapper -->
      </div>
      <!-- /#wrapper -->
   </body>
</html>
