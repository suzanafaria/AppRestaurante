<%@page import="negocio.Bebida"%>
<%@page import="java.util.List"%>
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
	<%List<Bebida> listaBebidas = (List<Bebida>) request.getAttribute("bebidas");%>

	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
			<c:import url="cabecalho.jsp"/>
			</div>
	   <div class="panel panel-default">
	   <div class="panel-body">
			<h3><b>Lista de Bebidas:</b></h3>
			<br>
		<form action="ProdutoController">
			<button type="submit" class="btn btn-default">Cadastrar Bebida</button>
		</form>

		<hr>

		<%if (listaBebidas != null) {%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>C�digo</th>
					<th>Nome</th>
					<th>Preco</th>
					<th>Marca</th>
					<th>Tamanho</th>
					<th>Alc�olica</th>
				</tr>
			</thead>
			<tbody>

				<%for (Bebida item : listaBebidas) {%>
				<tr>
					<td><%=item.getCodigo()%></td>
					<td><%=item.getNome()%></td>
					<td><%=item.getPreco()%></td>
					<td><%=item.getMarca()%></td>
					<td><%=item.getTamanho()%></td>
					<td><%=item.isAlcoolica()%></td>					
				</tr>
				<%}%>

			</tbody>
		</table>
		<%} else {%>
		<p>Ainda n�o existe nenhuma bebida cadastrada!</p>
		<%}%>
		
	</div>
	</div>
	</div>
	</div>


</body>
</html>