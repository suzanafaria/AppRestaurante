<%@page import="java.util.Set"%>
<%@page import="negocio.Bebida"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppRestaurante - BebidaLista</title>
</head>
<body>
	<%Set<Bebida> listaBebidas = (Set<Bebida>) request.getAttribute("bebidas");%>

	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
			<c:import url="cabecalho.jsp"/>
			</div>
	   <div class="panel panel-default">
	   <div class="panel-body">
			<h4><b>Bebidas:</b></h4>
			<br>
		<form action="BebidaController">
			<input type="hidden" name="operacao" value="new">
			<button type="submit" class="btn btn-default">Novo</button>
		</form>
		<form action="RestauranteController">
				<button type="submit" class="btn btn-default">Voltar</button>
		</form>

		<hr>

		<%if (listaBebidas != null) {%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Código</th>
					<th>Nome</th>
					<th>Preco</th>
					<th>Marca</th>
					<th>Tamanho</th>
					<th>Alcóolica</th>
					<th>Alterar</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>

				<%for (Bebida item : listaBebidas) {%>
				<tr>
					<td><%=item.getId()%></td>
					<td><%=item.getCodigo()%></td>
					<td><%=item.getNome()%></td>
					<td><%=item.getPreco()%></td>
					<td><%=item.getMarca()%></td>
					<td><%=item.getTamanho()%></td>
					<td><%=item.isAlcoolica()%></td>
					<td> Alterar</td>
					<form action="BebidaController" method="get">
						<input type="hidden" name="idProduto" value="<%=item.getId()%>">
						<td><button type="submit" class="btn btn-default">Excluir</button></td>
					</form>					
				</tr>
				<%}%>

			</tbody>
		</table>
		<%} else {%>
		<p>Ainda não existe nenhuma bebida cadastrada!</p>
		<%}%>
		
	</div>
	</div>
	</div>
	</div>


</body>
</html>