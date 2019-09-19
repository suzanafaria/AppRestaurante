<%@page import="negocio.Comida"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>AppRestaurante - ComidaCadastro</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>

	<%
	Comida comida = (Comida)session.getAttribute("newComida");
	%>

	<div class="container">

				<h1>Cadastro de Comida:</h1>
			

			<form action="ComidaController" method="post">
						
			<div class="form-group">
				<label for="codigo">Código do Produto:</label> <input type="text"
					class="form-control" id="codigo" value="<%=comida.getCodigo()%> name="codigo" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="nome">Nome do Produto:</label> <input type="text"
					class="form-control" id="nome" value="<%=comida.getNome()%> name="nome" readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="preco">Preço do Produto:</label> <input type="text"
					class="form-control" id="preco" value="<%=comida.getPreco()%> name="preco" readonly="readonly">
			</div>
			
		  	<div class="form-group">
					<label for="tipo">Tipo (Entrada, Prato Principal, Sanduiche, Pizza):</label> 
					<input type="text" class="form-control" id="tipo" name="tipo">
			</div>
			
			<div class="checkbox">
				<label for="serveDuasPessoas"> <input type="checkbox"
					name="serveDuasPessoas" value="true"><b>Porção para Duas Pessoas</b>
				</label>
			</div>

			<div class="checkbox">
				<label for="acompanhamentoExtra"> <input type="checkbox"
					name="acompanhamentoExtra" value="true"><b>Acompanhamento Extra</b>
				</label>
			</div>

					
			<br>

			<button type="submit" class="btn btn-default">Cadastrar</button>
</form>
</div>

</body>
</html>