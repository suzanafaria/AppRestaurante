<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Cadastro de Produto</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
		<h2>
			<b>Cadastro de Produtos:</b>
		</h2>
		<form action="ProdutoController" method="post">
						
			<div class="form-group">
				<label for="codigo">Código do Produto:</label> <input type="text"
					class="form-control" id="codigo" placeholder="Digite o código do produto"
					name="codigo">
			</div>
			<div class="form-group">
				<label for="nome">Nome do Produto:</label> <input type="text"
					class="form-control" id="nome" placeholder="Digite o nome do produto"
					name="nome">
			</div>
			
			<div class="form-group">
				<label for="preco">Preço do Produto:</label> <input type="text"
					class="form-control" id="preco" placeholder="Digite o preço do produto"
					name="preco">
			</div>
			
			<div class="form-group">
				<label for="tipo">Tipo de Produto:</label> 
				<select class="form-control" id="tipo" name="tipo">
					<option value="bebida">Bebida</option>
					<option value="comida">Comida</option>
					<option value="sobremesa">Sobremesa</option>
				</select>
			</div>
			
			<br>
			
			<button type="submit" class="btn btn-default">Cadastrar</button>
	</form>
	</div>
</body>
</html>