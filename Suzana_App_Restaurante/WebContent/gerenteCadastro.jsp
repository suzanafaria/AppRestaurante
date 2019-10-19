<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>AppRestaurante - GerenteCadastro</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
 	<div class="container">
	
				<h1>Cadastro de Gerentes:</h1>
		
		<form action="GerenteController">
				<button type="submit" class="btn btn-default">Voltar</button>
		</form>
		
		<form action=""GerenteController"" method="post">
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text"
					class="form-control" id="nome" placeholder="Entre com o nome"
					name="nome">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email"
					placeholder="Entre com o email" name="email">
			</div>
			<div class="form-group">
				<label for="telefone">Telefone para contato:</label> <input type="text"
					class="form-control" id="telefone"
					placeholder="Entre com o telefone" name="telefone">
			</div>
						
			<br>

			<button type="submit" class="btn btn-default">Cadastrar</button>
		</form>
	</div>

</body>
</html>