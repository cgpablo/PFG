<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>MRPsys</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bootstrap-3.3.6-dist/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bootstrap-3.3.6-dist/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../bootstrap-3.3.6-dist/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bootstrap-3.3.6-dist/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Registrar nuevo usuario</h3>
                    </div>
                    <div class="panel-body">
                        <form method="POST" action="${pageContext.request.contextPath}/pages/Register">
                            <fieldset>
	                                <div class="form-group">
	                                    <input class="form-control" placeholder="Usuario" name="username" type="text" autofocus>
	                                </div>
	                                <div class="form-group">
	                                    <input class="form-control" placeholder="Email" name="mail" type="text" autofocus>
	                                </div>
	                                <div class="form-group">
	                                    <input class="form-control" placeholder="Contrase�a" name="password" type="password" value="">
	                                </div>
	                                <div class="form-group">
	                                    <input class="form-control" placeholder="Repetir contrase�a" name="repeatPassword" type="password" value="">
	                                </div>
	                                <input class="btn btn-lg btn-success btn-block" type="submit" value="Registrarse">
	                                <br><center>�</center><br>
	                                <a href="logIn.jsp" class="btn btn-lg btn-success btn-block">Loguearse</a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="../bootstrap-3.3.6-dist/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bootstrap-3.3.6-dist/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bootstrap-3.3.6-dist/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../bootstrap-3.3.6-dist/dist/js/sb-admin-2.js"></script>

</body>

</html>
