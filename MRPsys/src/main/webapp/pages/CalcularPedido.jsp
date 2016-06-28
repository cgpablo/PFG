<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Clases.PedidoProducto" %>
<%@page import="modelo.Clases.PedidoKit" %>
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
                  <h1 class="page-header">Calcular aprovisionamiento</h1>
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
                     <div class="panel-heading">Necesidades de producto</div>
                     <!-- /.panel-heading -->
                     <div class="panel-body">
                        <div class="table-responsive table-bordered">
                           <table class="table">
                              <thead>
                                 <tr>
                                    <th>Referencia Pedido</th>
                                    <th>Referencia Producto</th>
                                    <th>Uds Requeridas</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <%
                                    List <PedidoProducto> productos = (List)request.getAttribute("pedidoProductos");
                                    PedidoProducto p;
                                    for(int i=0; i<productos.size();i++) {
                                  	p = productos.get(i);
                                 %>
                                 <tr>
                                    <td><%=p.getReferenciaPedido() %></td>
                                    <td><%=p.getProductoReferencia() %></td>
                                    <td><%=p.getNecesidad()%></td>
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
               <div class="col-lg-6">
                  <div class="panel panel-default">
                     <div class="panel-heading">Necesidades de kit</div>
                     <!-- /.panel-heading -->
                     <div class="panel-body">
                        <div class="table-responsive table-bordered">
                           <table class="table">
                              <thead>
                                 <tr>
                                    <th>Referencia Pedido</th>
                                    <th>Referencia Kit</th>
                                    <th>Uds Requeridas</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <%
                                    List <PedidoKit> kits = (List)request.getAttribute("pedidoKits");
                                    PedidoKit k;
                                    for(int i=0; i<kits.size();i++) {
                                  	k = kits.get(i);
                                 %>
                                 <tr>
                                    <td><%=k.getReferenciaPedido() %></td>
                                    <td><%=k.getReferenciaKit() %></td>
                                    <td><%=k.getNecesidadProd()%></td>
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
