<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Recheio Cadastro</title>
	<meta charset="utf-8">
</head>

<body>
	<div class="container">
		<h1> Cadastro de Recheio </h1>

		<form:form action="/recheio/inserirAction" method="post"
			modelAttribute="recheio">
			<fieldset>
				<legend><b><i>Informações:</i></b></legend>
				<label>Tipo:</label>
				<form:input path="tipo" />
				<br> <label>Valor:</label>
				<form:input path="valor" />
			</fieldset>
			<br>
			<form:button>Cadastrar</form:button>
		</form:form>

		<br>

	</div>
</body>
</html>