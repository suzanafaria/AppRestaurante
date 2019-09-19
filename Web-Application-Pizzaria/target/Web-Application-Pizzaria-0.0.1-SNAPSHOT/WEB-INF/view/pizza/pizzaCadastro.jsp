<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Pizza Cadastro</title>
	<meta charset="utf-8">
</head>

<body>
	<div class="container">
		<h1> Cadastro de Pizza </h1>

		<form:form action="/pizza/inserirAction" method="post" modelAttribute="pizza">
			<fieldset>
				<legend><b><i>Informações:</i></b></legend>
				<label>Nome:</label>
				<form:input path="nome" /> 
				<br>
				<!-- <label>Preço:</label>
				<form:input path="preco" />
				<br> -->

				<label>Massa - Tipo:</label>
				<form:input path="massa.tipo" /> 
				<br>
				<label>Massa - Valor:</label>
				<form:input path="massa.valor" /> 
				<br>
				
				<label>Recheio - Tipo:</label>
				<form:input path="recheio.tipo" /> 
				<br>
				<label>Recheio - Valor:</label>
				<form:input path="recheio.valor" /> 
				<br>
				
				<label>Tamanho da Pizza:</label>
				<form:input path="tamanho" /> 
				<br>
				
				<form:checkbox path="bordaRecheada" value="true"/>Com Borda Recheada?
			</fieldset>
			<br>
			<form:button>Cadastrar</form:button>
		</form:form>

		<br>

	</div>
</body>
</html>