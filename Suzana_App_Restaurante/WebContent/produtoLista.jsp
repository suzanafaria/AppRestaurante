<%@page import="negocio.Bebida"%>
<%@page import="modelo.Produto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppRestaurante - ProdutoLista</title>
</head>
<body>
	<%List<Produto> listaProdutos= (List<Produto>) request.getAttribute("produtos");%>
	<%String login = (String)request.getAttribute("usuarioLogado");%>

	<h1>Lista de Produtos</h1>

	<div class="container">

		<form action="ProdutoController" method="get">
			<input type="hidden" name="operacao" value="new">
			<button type="submit" class="btn btn-default">Novo Produto</button>
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
				</tr>
			</thead>
			<tbody>

				<%for (Produto item : listaProdutos) {%>
				<tr>
					<td><%=item.getCodigo()%></td>
					<td><%=item.getNome()%></td>
					<td><%=item.getPreco()%></td>		
					<td><%=item.obterTipo()%></td>		
				</tr>
				<%}%>

			</tbody>
		</table>
		<%} else {%>
		<p>Ainda não existe nenhuma bebida cadastrada!</p>
		<%}%>
		
	</div>

</body>
</html>