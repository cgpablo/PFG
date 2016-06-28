<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Clases.Kit" %>
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
                  <h1 class="page-header">Ver Kits</h1>
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
                     <div class="panel-heading" style="width:830px;">Lista de kits</div>
                     <!-- /.panel-heading -->
                     <div class="panel-body" style="width:832px;">
                        <div class="table-responsive table-bordered" style="width:800px;">
                           <table class="table">
                              <thead>
                                 <tr>
                                    <th>Referencia Kit</th>
                                    <th>Referencia Producto</th>
                                    <th>Uds Requeridas</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <%
                                    List <Kit> kits = (List)request.getAttribute("kits");
                                    Kit k;
                                    for(int i=0; i<kits.size();i++) {
                                    k = kits.get(i);
                                 %>
                                 <tr>
                                    <td><%=k.getReferencia() %></td>
                                    <td><%=k.getRefProd() %></td>
                                    <td><%=k.getUdProd()%></td>
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
