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
                  <h1 class="page-header" style="text-transform:uppercase; font-size:24px;">Modificar Pedido</h1>
               </div>
               <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
               <div class="col-lg-12">
                  <div class="panel panel-default">
                     <div class="panel-heading">Especificaciones del pedido</div>
                     <div class="panel-body">
                        <div class="row">
                           <div class="col-lg-6">
                              <form method="POST" action="${pageContext.request.contextPath}/pages/ModificarPedido">
                                 <div class="form-group">
                                 <%
                                    	Pedido d = (Pedido)request.getAttribute("pedido");
                                  %>
                                    <label>Referencia</label>
                                    <input type="hidden" name="refPed" value="<%=d.getReferenciaPedido() %>">
                                    <input class="form-control" id="disabledInput" value="<%=d.getReferenciaPedido() %>" type="text" disabled="" autofocus>
                                 </div>
                                 <div class="form-group">
                                    <label>Seleccionar referencia producto</label>
                                    <select class="form-control" name="refProd">
                                    <%
                                    	List <String> productos = (List) request.getAttribute("productos");
                                    	Object p;
                                    	for(int i=0; i<productos.size();i++) {
                                    	p = productos.get(i);
                                    %>
                                    	<option><%=p.toString()%></option>
                                    <%} %>
                                    </select>
                                 </div>
                                 <div class="form-group">
                                    <label>Unidades ordenadas</label>
                                    <input class="form-control" placeholder="Unidades" name="udProd" type="text" autofocus>
                                 </div>
                                 <button type="submit" class="btn btn-success">Modificar</button>
                                 <button type="reset" class="btn btn-warning">Reset</button>
                              </form>
                           </div>
                           <!-- /.col-lg-6 (nested) -->
                           <div class="col-lg-6">
                                 <h1>Datos del Pedido actual</h1>
                                 <div class="form-group">
                                    <label>Referencia producto</label>
                                    <select class="form-control" id="disabledSelect" disabled="">
                                    	<option><%=d.getRefProd()%></option>
                                    </select>
                                 </div>
                                 <div class="form-group">
                                    <label>Unidades ordenadas</label>
                                    <input class="form-control" id="disabledInput" disabled="" value="<%=d.getOrden()%>" type="text" autofocus>
                                 </div>
                           </div>
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