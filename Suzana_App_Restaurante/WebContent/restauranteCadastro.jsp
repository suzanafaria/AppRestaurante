<%@page import="negocio.Bebida"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>AppRestaurante - RestauranteCadastro</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">
				<h1>Cadastro de Restaurantes:</h1>

		<form action="RestauranteController">
			<button type="submit" class="btn btn-default">Voltar</button>
		</form>
		<br>
		<form action="RestauranteController" method="post">
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text"
					class="form-control" id="nome" name="nome">
			</div>
			<div class="form-group">
				<label for="categoria">Categoria:</label> <input type="text"
					class="form-control" id="categoria" name="categoria">
			</div>
			
			<div class="form-group">
				<label for="localizacaoBairro">Bairro:</label> <input type="text"
					class="form-control" id="localizacaoBairro" name="localizacaoBairro">
			</div>

			<button type="submit" class="btn btn-default">Cadastrar Restaurante</button>
		</form>
		</div>
		
</body>
</html>