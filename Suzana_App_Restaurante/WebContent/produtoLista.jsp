<%@page import="negocio.Bebida"%>
<%@page import="modelo.Produto"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppRestaurante - ProdutoLista</title>
</head>
<body>
	<%List<Produto> listaProdutos= (List<Produto>) request.getAttribute("produtos");%>
	<%String login = (String)request.getAttribute("usuarioLogado");%>

	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
			<c:import url="cabecalho.jsp"/>
			</div>
	   <div class="panel panel-default">
	   <div class="panel-body">
			<h4><b>Produtos:</b></h4>
			<br>
			<form action="ProdutoController" method="get">
			<input type="hidden" name="operacao" value="new">
			<button type="submit" class="btn btn-default">Novo</button>
		</form>

		<hr>

		<%if (listaProdutos != null) {%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Preco</th>
					<th>Tipo</th>
					<th>Alterar</th>
					<th>Excluir</th>
				</tr>
			</thead>
			<tbody>

				<%for (Produto item : listaProdutos) {%>
				<tr>
					<td><%=item.getCodigo()%></td>
					<td><%=item.getNome()%></td>
					<td><%=item.getPreco()%></td>		
					<td><%=item.obterTipo()%></td>
					<td> Alterar</td>
					<form action="ProdutoController" method="get">
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