<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Alterar Recheio</title>
</head>
<body>
	<h1>Alterar Cadastro de Recheio</h1>
	<form:form action="/recheio/alterarAction" method="post" modelAttribute="recheio">
		<form:hidden path="id" />
		<fieldset>
			<legend><b><i>Informações:</i></b></legend>
			<label>Tipo:</label>
			<form:input path="tipo" />
			<br>
			<label>Valor:</label>
			<form:input path="valor" />
		</fieldset>
		<br>
		<form:button>Alterar</form:button>
	</form:form>
</body>
</html>