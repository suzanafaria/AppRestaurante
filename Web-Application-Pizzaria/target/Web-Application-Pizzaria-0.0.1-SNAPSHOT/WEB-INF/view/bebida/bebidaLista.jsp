<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Bebida Listagem</title>
	
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

  <h2><b>Lista de Bebidas</b></h2>
  	<a href="/index">Voltar ao Menu</a>
  	<br>
	<a href="/bebida/inserir">Inserir Bebida</a>

	<hr>

 	<table border>
            <tr><th>Nome</th><th>Preço</th><th>Alterar</th><th>Excluir</th></tr>
            <c:forEach items="${bebidas}" var="bebida">
            	<tr>
					<td>${bebida.getNome()}</td>
					<td>${bebida.getPreco()}</td>
					
					<td>
						<a href="${pageContext.request.contextPath}/bebida/alterar/${bebida.getId()}">Alterar</a>
					</td>
					<td>
						<a href="#" onclick="remover('Deseja Remover?', '${pageContext.request.contextPath}/bebida/remover/${bebida.getId()}')">Remover</a>
					</td>
				</tr>
            </c:forEach>
            
    </table>
</div>
</body>
</html>