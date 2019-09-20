<%@page import="negocio.Sobremesa"%>
<%@page import="java.util.List"%>
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
	<%List<Sobremesa> listaSobremesas = (List<Sobremesa>) request.getAttribute("sobremesas");%>

	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
			<c:import url="cabecalho.jsp"/>
			</div>
	   <div class="panel panel-default">
	   <div class="panel-body">
			<h3><b>Lista de Sobremesas:</b></h3>
			<br>
			<form action="ProdutoController">
				<button type="submit" class="btn btn-default">Cadastrar Sobremesa</button>
			</form>

		<hr>

		<%if (listaSobremesas != null) {%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>C�digo</th>
					<th>Nome</th>
					<th>Preco</th>
					<th>Sobremesa Fria</th>
					<th>Vers�o Diet</th>
					<th>Cont�m Lactose</th>
				</tr>
			</thead>
			<tbody>

				<%for (Sobremesa item : listaSobremesas) {%>
				<tr>
					<td><%=item.getCodigo()%></td>
					<td><%=item.getNome()%></td>
					<td><%=item.getPreco()%></td>
					<td><%=item.isSobremesaFria()%></td>
					<td><%=item.isVersaoDiet()%></td>
					<td><%=item.isContemLactose()%></td>
				</tr>
				<%}%>

			</tbody>
		</table>
		<%} else {%>
		<p>Ainda n�o existe nenhuma sobremesa cadastrada!</p>
		<%}%>
		
	</div>
	</div>
	</div>
	</div>

</body>
</html>