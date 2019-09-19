<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Alterar Massa</title>
</head>
<body>
	<h1>Alterar Pedido</h1>
	<form:form action="/pedido/alterarAction" method="post" modelAttribute="pedido">
		<form:hidden path="id" />
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
				<label>Cliente:</label>
				<form:input path="cliente.nome" />
				<br> 
				<label>Produtos:</label>
				<form:input path="produtos.nome" />
				
			</fieldset>
			<br>
			<form:button>Alterar</form:button>
	</form:form>
</body>
</html>