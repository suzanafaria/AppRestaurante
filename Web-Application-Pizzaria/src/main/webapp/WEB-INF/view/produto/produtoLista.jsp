<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Produtos Listagem</title>
	
	<script>
		function remover(mensagem, url) {
			if (confirm(mensagem)) {
				window.location = url;
			}
		}
	</script>
</head>

<body>
<div class="container">

  	<h2><b>Lista de Produtos</b></h2>
  	
  	<a href="/">Voltar ao Menu</a>
  	<br>
  	
	<hr>

 	<table border>
            <tr>
            <th>Nome</th><th>Preço</th>
            <c:forEach items="${produtos}" var="produto">
            	<tr>
					<td>${produto.getNome()}</td>
					<td>${produto.getPreco()}</td>					
				</tr>
            </c:forEach>
            
    </table>
</div>
</body>
</html>