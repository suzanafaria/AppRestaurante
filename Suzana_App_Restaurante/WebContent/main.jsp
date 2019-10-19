<%@page import="negocio.Restaurante"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>AppRestaurante</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	List<Restaurante> lista = (List<Restaurante>)request.getAttribute("restaurantes");
	%>

	<div class="container">
		<div class="panel-group">
				<c:import url="cabecalho.jsp" />
					<div class="panel-body">
						<div class="btn btn-block">
							<div class="btn-group">
								<form action="RestauranteController" method="get">
									<button type="submit" class="btn btn-default" name="operacao" value="restauranteCadastro">Restaurante</button>
								</form>
					    	</div>								
							<div class="btn-group">
								<form action="GerenteController">
									<button type="submit" class="btn btn-default">Gerente</button>
								</form>
							</div>
							<div class="btn-group">
								<form action="BebidaController">
									<button type="submit" class="btn btn-default">Bebida</button>
								</form>
							</div>
							<div class="btn-group">
								<form action="ComidaController">
									<button type="submit" class="btn btn-default">Comida</button>
								</form>
							</div>
							<div class="btn-group">
								<form action="SobremesaController">
									<button type="submit" class="btn btn-default">Sobremesa</button>
								</form>
							</div>
						</div>
					</div>

			
		<div class="panel panel-default">
	   	<div class="panel-body">
<!-- 			<h3><b>Lista de Restaurantes:</b></h3> -->
	
		<%if (lista != null) {%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Restaurante</th>
					<th>Total</th>
					<th> </th>
					<th> </th>
					<th> </th>
					<th> </th>
				</tr>
			</thead>
			<tbody>

				<%for (Restaurante item : lista) {%>
				<tr>
					<td><%=item%></td>
					<td><%=item.getProdutos() == null ? 0 : item.getProdutos().size()%></td>
					<td>
					<form action="GerenteRestauranteController" method="get">
						<input type="hidden" name="id" value="<%=item.getId()%>">
							<button type="submit" class="btn btn-link">Gerente</button>
					</form>
					</td>
					
					<td>
			    	<form action="ProdutoRestauranteController" method="get">
			    		<input type="hidden" name="id" value="<%=item.getId()%>">
				        	<button type="submit" class="btn btn-link">Produtos</button>
			      	</form>
		        	</td>
					
					<td>
					<form action="ConsultaRestauranteController" method="get">
						<input type="hidden" name="id" value="<%=item.getId()%>">
							<button type="submit" class="btn btn-link">Detalhar</button>
					</form>
					</td>
					
					<td>
					<form action="ExclusaoRestauranteController" method="post">
						<input type="hidden" name="id" value="<%=item.getId()%>">
							<button type="submit" class="btn btn-link">Excluir</button>
					</form>
					</td>
				
				</tr>
				<%}%>

			</tbody>
		</table>
		<%} else {%>
		<p>Ainda não existe nenhum restaurante cadastrada!</p>
		<%}%>
		
	</div>
	</div>
	</div>
	</div>
	
</body>
</html>