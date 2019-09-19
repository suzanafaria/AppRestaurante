<%@page import="java.util.List"%>
<%@page import="negocio.Funcionario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>AppRestaurante - FuncionarioLista</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		List<Funcionario> listaFuncionarios = (List<Funcionario>) request.getAttribute("funcionarios");
	%>
	
	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
			<c:import url="cabecalho.jsp"/>
		   	 <div class="panel-body">
				<h1>Lista de Funcionários:</h1>
			</div>
			</div>
	   <div class="panel panel-default">
	   <div class="panel-body">

		<form action="funcionarioCadastro.jsp">
			<button type="submit" class="btn btn-default">Cadastrar
				Funcionário</button>
		</form>

		<hr>

		<%
			if (listaFuncionarios != null) {
		%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Telefone</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>

				<%
					for (Funcionario item : listaFuncionarios) {
				%>
				<tr>
					<td><%=item.getNome()%></td>
					<td><%=item.getEmail()%></td>
					<td><%=item.getTelefone()%></td>
					<td>
						<form action="FuncionarioController" method="get">
							<input type="hidden" name="idFuncionario" value="<%=item.getId()%>">
							<button type="submit" class="btn btn-default">Excluir</button>
						</form>
					</td>
				</tr>
				<%
					}
				%>

			</tbody>
		</table>
		<%
			} else {
		%>
		<p>Ainda não existe nenhum funcionário cadastrado!</p>
		<%
			}
		%>

	</div>
	</div>
	</div>
	</div>

</body>
</html>