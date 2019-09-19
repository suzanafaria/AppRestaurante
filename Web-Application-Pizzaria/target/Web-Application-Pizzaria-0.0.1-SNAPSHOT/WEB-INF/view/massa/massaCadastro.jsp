<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Massa Cadastro</title>
	<meta charset="utf-8">
</head>
<body>
	<div class="container">
		<h1> Cadastro de Massa </h1>

		<form:form action="/massa/inserirAction" method="post"
			modelAttribute="massa">
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