<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Cliente Cadastro</title>
	<meta charset="utf-8">
</head>

<body>
	<div class="container">
		<h1> Cadastro de Cliente </h1>

		<form:form action="/cliente/inserirAction" method="post" modelAttribute="cliente">
			<fieldset>
				<legend><b><i>Informações:</i></b></legend>
				<label>Nome:</label>
				<form:input path="nome" /> 
				<label>CPF:</label>
				<form:input path="cpf" />
				<br> 
				<label>Telefone:</label>
				<form:input path="telefone" />
			</fieldset>
			<br>
			<form:button>Cadastrar</form:button>
		</form:form>

		<br>

	</div>
</body>
</html>