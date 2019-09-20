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
			<div class="panel panel-default">
				<c:import url="cabecalho.jsp" />
			</div>
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="panel-body">
						<div class="btn btn-block">
							<div class="btn-group">
								<form action="funcionarioLista.jsp">
									<button type="submit" class="btn btn-default">Funcionário</button>
								</form>
							</div>
							<div class="btn-group">
								<form action="bebidaLista.jsp">
									<button type="submit" class="btn btn-default">Bebida</button>
								</form>
							</div>
							<div class="btn-group">
								<form action="comidaLista.jsp">
									<button type="submit" class="btn btn-default">Comida</button>
								</form>
							</div>
							<div class="btn-group">
								<form action="sobremesaLista.jsp">
									<button type="submit" class="btn btn-default">Sobremesa</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>