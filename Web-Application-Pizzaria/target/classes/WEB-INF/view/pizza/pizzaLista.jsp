<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Pizza Listagem</title>
	
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

  <h2><b>Lista de Pizzas</b></h2>
  	
  	<a href="/">Voltar ao Menu</a>
  	<br>
	<a href="/pizza/inserir">Inserir Pizza</a>

	<hr>

 	<table border>
            <tr><th>Nome</th><th>Massa</th><th>Recheio</th><th>Tamanho</th><th>Borda Recheada</th><th>Alterar</th><th>Excluir</th></tr>
            <c:forEach items="${pizzas}" var="pizza">
            	<tr>
					<td>${pizza.getNome()}</td>
					<td>${pizza.getMassa().getTipo()}</td>
					<td>${pizza.getRecheio().getTipo()}</td>
					<td>${pizza.getTamanho()}</td>
					<td>${pizza.isBordaRecheada()}</td>
					<td>
						<a href="${pageContext.request.contextPath}/pizza/alterar/${pizza.getId()}">Alterar</a>
					</td>
					<td>
						<a href="#" onclick="remover('Deseja Remover?', '${pageContext.request.contextPath}/pizza/remover/${pizza.getId()}')">Remover</a>
					</td>
				</tr>
            </c:forEach>
            
    </table>
</div>
</body>
</html>