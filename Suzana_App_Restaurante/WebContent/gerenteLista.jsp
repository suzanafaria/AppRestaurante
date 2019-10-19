<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="negocio.Gerente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>AppRestaurante - GerenteLista</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		Set<Gerente> listaGerentes = (Set<Gerente>) request.getAttribute("gerentes");
	%>
	
	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
			<c:import url="cabecalho.jsp"/>
			</div>
	   <div class="panel panel-default">
	   <div class="panel-body">
			<h4><b>Gerentes:</b></h4>
			<br>
			<form action="GerenteController">
			<input type="hidden" name="operacao" value="new">
				<button type="submit" class="btn btn-default">Novo</button>
			</form>
			<form action="RestauranteController">
				<button type="submit" class="btn btn-default">Voltar</button>
			</form>

		<hr>

		<%
			if (listaGerentes != null) {
		%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Telefone</th>
					<th>Alterar</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>

				<%
					for (Gerente item : listaGerentes) {
				%>
				<tr>
					<td><%=item.getNome()%></td>
					<td><%=item.getEmail()%></td>
					<td><%=item.getTelefone()%></td>
					<td> Alterar</td>
					<form action="GerenteController" method="get">
						<input type="hidden" name="idGerente" value="<%=item.getId()%>">
						<td><button type="submit" class="btn btn-default">Excluir</button></td>
					</form>
					
				</tr>
				<%
					}
				%>

			</tbody>
		</table>
		<%
			} else {
		%>
		<p>Ainda não existe nenhum gerente cadastrado!</p>
		<%
			}
		%>

	</div>
	</div>
	</div>
	</div>

</body>
</html>