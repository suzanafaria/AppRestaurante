<%@page import="java.util.Set"%>
<%@page import="negocio.Restaurante"%>
<%@page import="java.util.List"%>
<%@page import="negocio.Gerente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>AppRestaurante - GerenteRestaurante</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>

	<%
		Restaurante restaurante = (Restaurante)request.getAttribute("restaurante");
		Set<Gerente> listaGerentes = (Set<Gerente>)request.getAttribute("gerentes");
		
		int idGerente = restaurante.getGerente() != null ? restaurante.getGerente().getId() : 0;
	%>

	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
			<c:import url="cabecalho.jsp"/>
			</div>
	   <div class="panel panel-default">
	   <div class="panel-body">
			<h4><b>GerenteRestaurante:</b></h4>
			<br>
		<form action="RestauranteController">
			<button type="submit" class="btn btn-default">Voltar</button>
		</form>
		
		<br>

			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text"
					class="form-control" id="nome" name="nome" readonly="readonly" value="<%= restaurante.getNome()%>">
			</div>
			<div class="form-group">
				<label for="categoria">Categoria:</label> <input type="text"
					class="form-control" id="categoria" name="categoria" readonly="readonly" value="<%= restaurante.getCategoria()%>">
			</div>
			
			<div class="form-group">
				<label for="localizacaoBairro">Bairro:</label> <input type="text"
					class="form-control" id="localizacaoBairro" name="localizacaoBairro" readonly="readonly" value="<%= restaurante.getLocalizacaoBairro()%>">
			</div>

			
			<form action="GerenteRestauranteController" method="post">
			<div class="form-group">
				<label for="funcionario">Gerentes:</label> 
				<%if(listaGerentes.size() > 0){%>
				  <label for="gerente">Gerente:</label>
				  <select class="form-control" name="idGerente">
			    	<%for(Gerente item : listaGerentes){%>
				    <option <%=idGerente == item.getId() ? "selected" : ""%> value="<%=item.getId()%>"><%=item%></option>
			    	<%}%>
			      </select>
			    	<%} else {%>
			       <label>Nenhum gerente associado a este restaurante!</label>
		       <%} %>
			</div>	
				
			
			<button type="submit" class="btn btn-default" <%=listaGerentes.size() == 0 ? "disabled" : "" %>>Gravar</button>
			
		</form>
		</div>
		</div>
		</div>
		</div>

		
</body>
</html>