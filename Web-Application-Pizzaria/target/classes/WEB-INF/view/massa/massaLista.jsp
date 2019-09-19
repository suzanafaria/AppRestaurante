<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Massa Listagem</title>
  	<meta charset="utf-8">
  	
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

  <h2><b>Opções de Massa</b></h2>
  	<a href="/">Voltar ao Menu</a>
  	<br>
	<a href="/massa/inserir">Inserir Massa</a>

	<hr>


 	<table border>
            <tr><th>Tipo</th><th>Valor</th><th>Alterar</th><th>Excluir</th></tr>
            <c:forEach items="${massas}" var="massa">
            	<tr>
					<td>${massa.getTipo()}</td>
					<td>${massa.getValor()}</td>
					<td>
						<a href="${pageContext.request.contextPath}/massa/alterar/${massa.getId()}">Alterar</a>
					</td>
					<td>
						<a href="#" onclick="remover('Deseja Remover?', '${pageContext.request.contextPath}/massa/remover/${massa.getId()}')">Remover</a>
					</td>
				</tr>
            </c:forEach>
            
    </table>
</div>
</body>
</html>