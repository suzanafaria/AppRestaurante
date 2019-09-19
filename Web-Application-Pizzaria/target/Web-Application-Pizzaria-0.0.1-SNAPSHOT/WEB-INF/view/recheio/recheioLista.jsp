<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Recheio Listagem</title>
	
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

  <h2><b>Opções de Recheio</b></h2>
  	<a href="/index">Voltar ao Menu</a>
  	<br>
	<a href="/recheio/inserir">Inserir Recheio</a>

	<hr>

 	<table border>
            <tr><th>Tipo</th><th>Valor</th><th>Alterar</th><th>Excluir</th></tr>
            <c:forEach items="${recheios}" var="recheio">
            	<tr>
					<td>${recheio.getTipo()}</td>
					<td>${recheio.getValor()}</td>
					<td>
						<a href="${pageContext.request.contextPath}/recheio/alterar/${recheio.getId()}">Alterar</a>
					</td>
					<td>
						<a href="#" onclick="remover('Deseja Remover?', '${pageContext.request.contextPath}/recheio/remover/${recheio.getId()}')">Remover</a>
					</td>
				</tr>
            </c:forEach>
            
    </table>
</div>
</body>
</html>