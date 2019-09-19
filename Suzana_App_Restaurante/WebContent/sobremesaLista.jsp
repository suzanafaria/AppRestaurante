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

	<h1>Lista de Sobremesas</h1>

	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
			<c:import url="cabecalho.jsp"/>
		   	 <div class="panel-body">
				<h1>Lista de Sobremesas:</h1>
			</div>
			</div>
	   <div class="panel panel-default">
	   <div class="panel-body">

		<form action="produtoCadastro.jsp">
			<button type="submit" class="btn btn-default">Cadastrar Sobremesa</button>
		</form>

		<hr>

		<%if (listaSobremesas != null) {%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Preco</th>
					<th>Sobremesa Fria</th>
					<th>Versão Diet</th>
					<th>Contém Lactose</th>
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
		<p>Ainda não existe nenhum funcionário cadastrado!</p>
		<%}%>
		
	</div>
	</div>
	</div>
	</div>

</body>
</html>