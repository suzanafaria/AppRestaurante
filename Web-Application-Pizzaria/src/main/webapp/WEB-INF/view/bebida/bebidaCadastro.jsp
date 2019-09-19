<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Bebida Cadastro</title>
	<meta charset="utf-8">
</head>

<body>
	<div class="container">
		<h1> Cadastro de Bebida </h1>

		<form:form action="/bebida/inserirAction" method="post" modelAttribute="bebida">
			<fieldset>
				<legend><b><i>Informações:</i></b></legend>
				<label>Nome:</label>
				<form:input path="nome" /> 
				<br>
				<label>Preço:</label>
				<form:input path="preco" />
				
			</fieldset>
			<br>
			<form:button>Cadastrar</form:button>
		</form:form>

		<br>

	</div>
</body>
</html>