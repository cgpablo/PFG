<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${pageContext.request.contextPath}/bootstrap-3.3.6-dist/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/bootstrap-3.3.6-dist/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="${pageContext.request.contextPath}/bootstrap-3.3.6-dist/bower_components/metisMenu/dist/metisMenu.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="${pageContext.request.contextPath}/bootstrap-3.3.6-dist/dist/js/sb-admin-2.js"></script>
<link href="${pageContext.request.contextPath}/bootstrap-3.3.6-dist/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="${pageContext.request.contextPath}/bootstrap-3.3.6-dist/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/bootstrap-3.3.6-dist/dist/css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath}/bootstrap-3.3.6-dist/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">    

<title>MRPsys</title>
</head>
<body>
	<!-- Navigation -->
      <nav class="navbar navbar-default navbar-static-top" role="navigation"
      style="margin-bottom: 0">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/pages/main.jsp">MRPsys main page</a>
        </div>
        <!-- /.navbar-header -->
        <ul class="nav navbar-top-links navbar-right">
          <li class="dropdown">
          	<a class="dropdown-toggle" data-toggle="dropdown" href="#">
          		<i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
          	</a>
          	<ul class="dropdown-menu dropdown-user">
              <li>
                <a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
              </li>
              <li>
                <a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
              </li>
               <li class="divider"></li>
              <li>
                <a href="${pageContext.request.contextPath}/pages/VerUsuarios"><i class="fa fa-user fa-fw"></i> Ver Users</a>
              </li>
              <li>
                <a href="${pageContext.request.contextPath}/pages/LoadModificarUsuario"><i class="fa fa-gear fa-fw"></i> Modificar Usuario</a>
              </li>
              <li>
                <a href="${pageContext.request.contextPath}/pages/LoadBorrarUsuario"><i class="fa fa-gear fa-fw"></i> Borrar Usuario</a>
              </li>
              <li class="divider"></li>
              <li>
                <a href="${pageContext.request.contextPath}/pages/logIn.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
              </li>
            </ul>
          </li>
        </ul>
        <!-- /.navbar-top-links -->
        <div class="navbar-default sidebar" role="navigation">
          <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
              <li>
                <a href="main.jsp"><i class="fa fa-dashboard fa-fw"></i> Index</a>
              </li>
              <li class="dropdown">
                <a href="#"><i class="fa fa-wrench fa-fw"></i>Gestionar Pedidos</a>
                <ul class="nav nav-second-level">
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/VerPedidos"><i class="fa fa-table fa-fw"></i>Ver Pedidos</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/LoadAddPedido"><i class="fa fa-files-o fa-fw"></i>Añadir Pedido</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/LoadModificarPedido"><i class="fa fa-edit fa-fw"></i>Modificar Pedido</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/LoadBorrarPedido"><i class="fa fa-sign-out fa-fw"></i>Borrar Pedido</a>
                  </li>
                </ul>
              </li>
              <li class="dropdown">
                <a href="#"><i class="fa fa-wrench fa-fw"></i>Gestionar Kit's</a>
                <ul class="nav nav-second-level">
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/VerKits"><i class="fa fa-table fa-fw"></i>Ver Kits</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/LoadAddKit"><i class="fa fa-files-o fa-fw"></i>Añadir Kit</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/LoadModificarKit"><i class="fa fa-edit fa-fw"></i>Modificar Kit</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/LoadBorrarKit"><i class="fa fa-sign-out fa-fw"></i>Borrar Kit</a>
                  </li>
                </ul>
              </li>
              <li class="dropdown">
                <a href="#"><i class="fa fa-wrench fa-fw"></i>Gestionar Productos</a>
                <ul class="nav nav-second-level">
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/VerProductos"><i class="fa fa-table fa-fw"></i>Ver Productos</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/addProduct.jsp"><i class="fa fa-files-o fa-fw"></i>Añadir Producto</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/LoadModificarProducto"><i class="fa fa-edit fa-fw"></i>Modificar Producto</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/LoadBorrarProducto"><i class="fa fa-sign-out fa-fw"></i>Borrar productos</a>
                  </li>
                </ul>
              </li>
              <li class="dropdown">
                <a href="#"><i class="fa fa-wrench fa-fw"></i>Gestionar Materiales</a>
                <ul class="nav nav-second-level">
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/VerMateriales"><i class="fa fa-table fa-fw"></i>Ver Materiales</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/addMaterial.jsp"><i class="fa fa-files-o fa-fw"></i>Añadir Material</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/LoadModificarMaterial"><i class="fa fa-edit fa-fw"></i>Modificar Material</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/pages/LoadBorrarMaterial"><i class="fa fa-sign-out fa-fw"></i>Borrar Material</a>
                  </li>
                </ul>
              </li>
            </ul>
          </div>
          <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
      </nav>
</body>
</html>