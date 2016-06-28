<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Clases.Pedido" %>
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
                  <h1 class="page-header">Calcular Aprovisionamiento</h1>
               </div>
               <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <!-- /.row -->
            <!-- /.row -->
            <div class="row">
               <!-- /.col-lg-6 -->
               <div class="col-lg-6">
                  <div class="panel panel-default">
                     <div class="panel-heading">Lista de pedidos</div>
                     <!-- /.panel-heading -->
                     <div class="panel-body">
                        <div class="table-responsive table-bordered">
                           <table class="table">
                              <thead>
                                 <tr>
                                    <th>Referencia</th>
                                    <th>Fecha</th>
                                    <th>Acción</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <%
                                    List <Pedido> pedidos = (List)request.getAttribute("pedidos");
                                    Pedido p;
                                    for(int i=0; i<pedidos.size();i++) {
                                    p = pedidos.get(i);
                                 %>
                                 <tr>
                                    <td><%=p.getReferenciaPedido() %></td>
                                    <td>Fecha</td>
                                    <td>
										<form method="POST" action="${pageContext.request.contextPath}/pages/LoadAddCalcularPedido">
											<input type="hidden" name="referencia" value="<%=p.getReferenciaPedido() %>">
											<button type="submit" class="btn btn-warning" name="modificar">Calcular</button>					
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
