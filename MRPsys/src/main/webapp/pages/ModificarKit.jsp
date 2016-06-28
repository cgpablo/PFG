<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Clases.Kit" %>
<%@page import="modelo.Clases.Producto" %>
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
         <%request.getSession().getAttribute("productos"); %>
            <div class="row">
               <div class="col-lg-12">
                  <h1 class="page-header" style="text-transform:uppercase; font-size:24px;">Modificar Kit</h1>
               </div>
               <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
               <div class="col-lg-12">
                  <div class="panel panel-default">
                     <div class="panel-heading">Especificaciones del kit</div>
                     <div class="panel-body">
                        <div class="row">
                           <div class="col-lg-6">
                              <form method="POST" action="${pageContext.request.contextPath}/pages/ModificarKit">
                                 <div class="form-group">
                                     <%
                                    	Kit k = (Kit)request.getAttribute("kit");
                                  	%>
                                    <label>Referencia Kit</label>
                                    <input type="hidden" name="refKit" value="<%=k.getReferencia() %>">
                                    <input class="form-control" id="disabledInput" value="<%=k.getReferencia() %>" type="text" disabled="" autofocus>
                                 </div>
                                 <div class="form-group">
                                    <label>Seleccionar referencia producto</label>
                                    <select class="form-control" name="refProd">
                                    <%
                                    	List <String> productos = (List)request.getAttribute("productos");
                                    	String p;
                                    	for(int i=0; i<productos.size();i++) {
                                    	p = productos.get(i);
                                     %>
                                     <option><%=p.toString()%></option>
                                       <%} %>
                                    </select>
                                 </div>
                                 <div class="form-group">
                                    <label>Unidades de producto requeridas</label>
                                    <input class="form-control" placeholder="Unidades" name="prod" type="text" autofocus>
                                 </div>                                 <button type="submit" class="btn btn-success">Añadir</button>
                                 <button type="reset" class="btn btn-primary">Reset</button>
                              </form>
                           </div>
                           <!-- /.col-lg-6 (nested) -->
						   <div class="col-lg-6">
                                 <h1>Datos del Kit actual</h1>
                                 <div class="form-group">
                                    <label>Referencia producto</label>
                                    <select class="form-control" id="disabledSelect" disabled="">
                                     <option><%=k.getRefProd() %></option>
                                    </select>
                                 </div>
                                 <div class="form-group">
                                    <label>Unidades de producto</label>
                                    <input class="form-control" id="disabledInput" disabled="" value="<%=k.getUdProd() %>" type="text" autofocus>
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