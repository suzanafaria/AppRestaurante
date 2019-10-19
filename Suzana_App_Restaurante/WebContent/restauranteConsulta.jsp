<%@page import="negocio.Restaurante"%>
<%@page import="java.util.Set"%>
<%@page import="modelo.Produto"%>
<%@page import="java.util.List"%>
<%@page import="negocio.Gerente"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>AppRestaurante - AssociarProdutos</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>

	<%
		Restaurante restaurante = (Restaurante)request.getAttribute("restaurante");
	%>

	<div class="container">
		<div class="panel-group">
			<div class="panel panel-default">
			<c:import url="cabecalho.jsp"/>
			</div>
	   <div class="panel panel-default">
	   <div class="panel-body">
			<h4><b>Associar Produtos:</b></h4>
			<br>
		<form action="RestauranteController">
			<button type="submit" class="btn btn-default">Voltar</button>
		</form>
		<br>
		
		<form action="" method="get">
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


		<div class="form-group">
		  <%if(restaurante.getProdutos() != null ? restaurante.getProdutos().size() > 0 : false){%>
	  		  <label>Produtos:</label>		  
	    	<%for(Produto item : restaurante.getProdutos()){%>
			  <div class="container">
	    		<input type="checkbox" disabled checked name="produtos"> <%=item%>
	  		  </div>
	    	<%}
	       } else {%>
	      <label>Nenhum produto disponível para o Restaurante escolhido!</label>
	       <%} %>
	    
		</div>
			
		</form>
		
		</div>
		</div>
		</div>
		</div>

</body>
</html>