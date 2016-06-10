<%@page import="modelo.Clases.Usuario" %>
<%@page import="java.util.*" %>
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
                  <h1 class="page-header">Ver Usuarios</h1>
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
                     <div class="panel-heading">Lista de usuarios</div>
                     <!-- /.panel-heading -->
                     <div class="panel-body">
                        <div class="table-responsive table-bordered">
                           <table class="table">
                              <thead>
                                 <tr>
                                    <th>Username</th>
                                    <th>Mail</th>
                                    <th>Password</th>
                                 </tr>
                              </thead>
                              <tbody>
                              <%
                              		List <Usuario> usuarios = (List)request.getSession().getAttribute("usuarios");
                              		Usuario u;
                              		for(int i=0; i<usuarios.size();i++) {
                              		u = usuarios.get(i);
                               %>
                                 <tr>
                                    <td><%=u.getUsername()%></td>
                                    <td><%=u.getMail() %></td>
                                    <td><%=u.getPassword()%></td>
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