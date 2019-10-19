<%@page import="java.util.Set"%>
<%@page import="negocio.Comida"%>
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
	<%Set<Comida> listaComidas = (Set<Comida>) request.getAttribute("comidas");%>

	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
			<c:import url="cabecalho.jsp"/>
			</div>
	   <div class="panel panel-default">
	   <div class="panel-body">
			<h4><b>Comidas:</b></h4>
			<br>
		<form action="ComidaController">
			<input type="hidden" name="operacao" value="new">
			<button type="submit" class="btn btn-default">Novo</button>
		</form>
		<form action="RestauranteController">
				<button type="submit" class="btn btn-default">Voltar</button>
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
					<th>Alterar</th>
					<th>Excluir</th>
					
				</tr>
			</thead>
			<tbody>

				<%for (Comida item : listaComidas) {%>
				<tr>
					<td><%=item.getId()%></td>
					<td><%=item.getCodigo()%></td>
					<td><%=item.getNome()%></td>
					<td><%=item.getPreco()%></td>
					<td><%=item.getTipo()%></td>
					<td><%=item.isServeDuasPessoas()%></td>
					<td><%=item.isAcompanhamentoExtra()%></td>
					<td> Alterar</td>
					<form action="ComidaController" method="get">
						<input type="hidden" name="idProduto" value="<%=item.getId()%>">
						<td><button type="submit" class="btn btn-default">Excluir</button></td>
					</form>
				</tr>
				<%}%>

			</tbody>
		</table>
		<%} else {%>
		<p>Ainda não existe nenhuma comida cadastrada!</p>
		<%}%>
		
	</div>
	</div>
	</div>
	</div>

</body>
</html>