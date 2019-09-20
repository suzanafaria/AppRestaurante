<%@page import="negocio.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppRestaurante</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>
<style>
div.a {
	text-align: center;
}
</style>

	<% Usuario usuario = (Usuario)session.getAttribute("usuarioLogado");%>

	<div class="container">
	<div class="panel-heading">
	<div class="a">
		<h2><b>AppRestaurante: Sistema de Cadastro</b></h2>
	</div>	
	<hr />
		<h4> Olá <%=usuario.getNome() %> </h4>

		<form action="login.jsp">
		   		<button type="submit" class="btn btn-warning">Sair</button>
		</form>
	</div>
	</div>
</body>
</html>