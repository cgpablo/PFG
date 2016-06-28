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
    <title>iLineMRPsys</title>
  </head>
  <body>
  	<div id="wrapper">
    	<jsp:include page="/tools/navBar.jsp"/>
    	<div id="page-wrapper">
    	<div class="row">
          <div class="col-lg-12">
            <h1 class="page-header">Main page</h1>
          </div>
          <!-- /.col-lg-12 -->
        </div>
        <div class="row">
        <div class="col-lg-8">
        </div>
          <div class="col-lg-4">
    	<div class="chat-panel panel panel-default">
              <div class="panel-heading">
                <i class="fa fa-comments fa-fw"></i>Comentarios
              </div>
              <!-- /.panel-heading -->
              <div class="panel-body">
                <ul class="chat">
                  <li class="left clearfix">
                    <div class="chat-body clearfix">
                      <div class="header">
                        <strong class="primary-font">Admin</strong>
                      </div>
                      <p>Esto es una prueba.</p>
                    </div>
                  </li>
                  <li class="left clearfix">
                    <div class="chat-body clearfix">
                      <div class="header">
                        <strong class="primary-font">Admin</strong>
                      </div>
                      <p>Esto es otra prueba.</p>
                    </div>
                  </li>
                </ul>
              </div>
              <!-- /.panel-body -->
              <div class="panel-footer">
                <div class="input-group">
                  <input id="btn-input" type="text" class="form-control input-sm" placeholder="Escribir el mensaje aquí">
                  <span class="input-group-btn">
                    <button class="btn btn-warning btn-sm" id="btn-chat">Send</button>
                  </span>
                </div>
              </div>
              <!-- /.panel-footer -->
            </div>
   		</div>
    </div>
  </body>
</html>