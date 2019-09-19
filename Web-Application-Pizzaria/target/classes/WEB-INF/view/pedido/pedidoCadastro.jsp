<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Pedido Cadastro</title>
	<meta charset="utf-8">
</head>
<body>
	<div class="container">
		<h1> Cadastro de Pedido </h1>

		<form:form action="/pedido/inserirAction" method="post" modelAttribute="pedido">
			<fieldset>
				<legend><b><i>Informações:</i></b></legend>
				<label>Número:</label>
				<form:input path="numero" />
				<br> 
				<label>Valor Total:</label>
				<form:input path="valorTotal" />
				<br>
				<label>Forma de Pagamento:</label>
				<form:input path="formaPagamento" />
				<br> 
				<!-- 
				<label>Cliente:</label>
				<form:input path="cliente" />
				<br> 
				 -->
				
				<form:select path="cliente.nome" id="cliente">
					<form:option value="NONE" label="--- Select ---" />
					<form:options items="${cliente}" />
				</form:select>
				
				<br>

				<label>Produtos:</label>
				<form:input path="produtos" />
				
			</fieldset>
			<br>
			<form:button>Cadastrar</form:button>
		</form:form>

		<br>

	</div>
</body>
</html>