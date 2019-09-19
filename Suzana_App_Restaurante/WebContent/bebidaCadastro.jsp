<%@page import="negocio.Bebida"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>AppRestaurante - BebidaCadastro</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
	<%
	Bebida bebida = (Bebida)session.getAttribute("newBebida");
	%>
<div class="container">
				<h1>Cadastro de Bebida:</h1>

		<form action="BebidaController" method="post">
			<div class="form-group">
				<label for="codigo">Código do Produto:</label> <input type="text"
					class="form-control" id="codigo" value="<%=bebida.getCodigo()%> name="codigo" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="nome">Nome do Produto:</label> <input type="text"
					class="form-control" id="nome" value="<%=bebida.getNome()%> name="nome" readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="preco">Preço do Produto:</label> <input type="text"
					class="form-control" id="preco" value="<%=bebida.getPreco()%> name="preco" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="marca">Marca:</label> <input type="text"
					class="form-control" id="marca" placeholder="Digite o nome da marca da bebida"
					name="marca">
			</div>
			<div class="form-group">
				<label for="tamanho">Tamanho:</label> <input type="text"
					class="form-control" id="tamanho"
					placeholder="Digite o tamanho do produto" name="tamanho">
			</div>
			<div class="checkbox">
				<label for="alcoolica">
				<input type="checkbox" name="alcoolica" value="true"><b>Alcoólica</b></label>
			</div>
			
			<br>

			<button type="submit" class="btn btn-default">Cadastrar Bebida</button>
		</form>
		</div>
		
</body>
</html>