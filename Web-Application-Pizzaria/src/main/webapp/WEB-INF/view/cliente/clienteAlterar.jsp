<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Alterar Cliente</title>
</head>
<body>
	<h1>Alterar Cadastro de Cliente</h1>
	<form:form action="/cliente/alterarAction" method="post" modelAttribute="cliente">
		<form:hidden path="id" />
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
		<form:button>Alterar</form:button>
	</form:form>
</body>
</html>