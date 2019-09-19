<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>AppRestaurante</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
</head>
<body>
	<%
	String titulo = (String)request.getAttribute("titulo");
	String mensagem = (String)request.getAttribute("mensagem");
	String controller = (String)request.getAttribute("controller");
	%>
<div class="container">
<div class="panel-group">
<div class="panel panel-default">
<div class="panel-heading">
	<c:import url="cabecalho.jsp"/>

	<form action="<%=controller%>">
		<button type="submit" class="btn btn-link">Voltar</button>
	</form>
   </div>
   
   	<div class="panel-body">
	  <div class="btn-group btn-group-justified">
		  <h2><%=titulo%></h2>
		  <div class="alert alert-success">
		    <strong>Cadastro realizado com sucesso!</strong> <%=mensagem%>
		  </div>
	  </div>
	</div>
</div>
</div>
</div>
</body>
</html>