<%@page import="negocio.Sobremesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>AppRestaurante - SobremesaCadastro</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">

				<h1>Cadastro de Sobremesa:</h1>

		<form action="SobremesaController">
			<button type="submit" class="btn btn-default">Voltar</button>
		</form>

		<form action="SobremesaController" method="post">
			<div class="form-group">
				<label for="codigo">Código do Produto:</label> <input type="text"
					class="form-control" id="codigo" name="codigo">
			</div>
			<div class="form-group">
				<label for="nome">Nome do Produto:</label> <input type="text"
					class="form-control" id="nome" name="nome">
			</div>
			
			<div class="form-group">
				<label for="preco">Preço do Produto:</label> <input type="text"
					class="form-control" id="preco" name="preco">
			</div>
			<div class="checkbox">
				<label for="sobremesaFria">
				<input type="checkbox" name="sobremesaFria" value="true"><b>Sobremesa Fria</b></label>
			</div>
			
			<div class="checkbox">
				<label for="versaoDiet">
				<input type="checkbox" name="versaoDiet" value="true"><b>Versão Diet</b></label>
			</div>
			
			<div class="checkbox">
				<label for="contemLactose">
				<input type="checkbox" name="contemLactose" value="true"><b>Opção de ser sem Lactose</b></label>
			</div>
			<br>

			<button type="submit" class="btn btn-default">Cadastrar</button>
		</form>
	</div>
		
</body>
</html>