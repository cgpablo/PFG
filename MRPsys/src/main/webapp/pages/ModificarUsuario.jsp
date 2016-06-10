<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Clases.Usuario" %>
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
                  <h1 class="page-header" style="text-transform:uppercase; font-size:24px;">Modificar Usuario</h1>
               </div>
               <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
               <div class="col-lg-12">
                  <div class="panel panel-default">
                     <div class="panel-heading">Especificaciones del producto</div>
                     <div class="panel-body">
                        <div class="row">
                           <div class="col-lg-6">
                              <form method="POST" action="${pageContext.request.contextPath}/pages/ModificarUsuario">
                                 <div class="form-group">
                                 <%
                                    	Usuario u = (Usuario)request.getAttribute("usuario");
                                  %>
                                    <label>Username</label>
                                    <input type="hidden" name="username" value="<%=u.getUsername() %>">
                                    <input class="form-control" id="disabledInput" disabled="" value="<%=u.getUsername()%>" type="text">
                                 </div>
                                 <div class="form-group">
                                    <label>Mail</label>
                                    <input class="form-control" name="mail" value="<%=u.getMail() %>" type="text" autofocus>
                                 </div>
                                 <div class="form-group">
                                    <label>Password</label>
                                    <input class="form-control" name="password" value="<%=u.getPassword() %>" type="text" autofocus>
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