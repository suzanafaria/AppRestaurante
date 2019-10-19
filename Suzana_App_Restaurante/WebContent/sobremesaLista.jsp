<%@page import="java.util.Set"%>
<%@page import="negocio.Sobremesa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppRestaurante - SobremesaLista</title>
</head>
<body>
	<%Set<Sobremesa> listaSobremesas = (Set<Sobremesa>) request.getAttribute("sobremesas");%>

	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
			<c:import url="cabecalho.jsp"/>
			</div>
	   <div class="panel panel-default">
	   <div class="panel-body">
			<h4><b>Sobremesas:</b></h4>
			<br>
			<form action="SobremesaController">
			<input type="hidden" name="operacao" value="new">
				<button type="submit" class="btn btn-default">Novo</button>
			</form>
			<form action="RestauranteController">
				<button type="submit" class="btn btn-default">Voltar</button>
			</form>

		<hr>

		<%if (listaSobremesas != null) {%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Código</th>
					<th>Nome</th>
					<th>Preco</th>
					<th>Sobremesa Fria</th>
					<th>Versão Diet</th>
					<th>Contém Lactose</th>
					<th>Alterar</th>
					<th>Excluir</th>
					
				</tr>
			</thead>
			<tbody>

				<%for (Sobremesa item : listaSobremesas) {%>
				<tr>
					<td><%=item.getId()%></td>
					<td><%=item.getCodigo()%></td>
					<td><%=item.getNome()%></td>
					<td><%=item.getPreco()%></td>
					<td><%=item.isSobremesaFria()%></td>
					<td><%=item.isVersaoDiet()%></td>
					<td><%=item.isContemLactose()%></td>
					<td> Alterar</td>
					<form action="SobremesaController" method="get">
						<input type="hidden" name="idProduto" value="<%=item.getId()%>">
						<td><button type="submit" class="btn btn-default">Excluir</button></td>
					</form>
				</tr>
				<%}%>

			</tbody>
		</table>
		<%} else {%>
		<p>Ainda não existe nenhuma sobremesa cadastrada!</p>
		<%}%>
		
	</div>
	</div>
	</div>
	</div>

</body>
</html>