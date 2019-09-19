<%@page import="negocio.Comida"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppRestaurante - ComidaLista</title>
</head>
<body>
	<%List<Comida> listaComidas = (List<Comida>) request.getAttribute("comidas");%>

	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
			<c:import url="cabecalho.jsp"/>
		   	 <div class="panel-body">
				<h1>Lista de Comidas:</h1>
			</div>
			</div>
	   <div class="panel panel-default">
	   <div class="panel-body">
		<form action="comidaCadastro.jsp">
			<button type="submit" class="btn btn-default">Cadastrar Comida</button>
		</form>

		<hr>

		<%if (listaComidas != null) {%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Preco</th>
					<th>Tipo</th>
					<th>Porção para Duas Pessoas</th>
					<th>Acompanhamento Extra</th>
				</tr>
			</thead>
			<tbody>

				<%for (Comida item : listaComidas) {%>
				<tr>
					<td><%=item.getCodigo()%></td>
					<td><%=item.getNome()%></td>
					<td><%=item.getPreco()%></td>
					<td><%=item.getTipo()%></td>
					<td><%=item.isServeDuasPessoas()%></td>
					<td><%=item.isAcompanhamentoExtra()%></td>
				</tr>
				<%}%>

			</tbody>
		</table>
		<%} else {%>
		<p>Ainda não existe nenhum funcionário cadastrado!</p>
		<%}%>
		
	</div>
	</div>
	</div>
	</div>

</body>
</html>