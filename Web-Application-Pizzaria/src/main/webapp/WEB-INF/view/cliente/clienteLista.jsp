<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Cliente Listagem</title>
	
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

  <h2><b>Lista de Clientes</b></h2>
	<a href="/">Voltar ao Menu</a>
	<br>
	<a href="/cliente/inserir">Novo Cliente</a>

	<hr>

 	<table border>
            <tr><th>Nome</th><th>CPF</th><th>Telefone</th><th>Alterar</th><th>Excluir</th></tr>
            <c:forEach items="${clientes}" var="cliente">
            	<tr>
					<td>${cliente.getNome()}</td>
					<td>${cliente.getCpf()}</td>
					<td>${cliente.getTelefone()}</td>
					<td>
						<a href="${pageContext.request.contextPath}/cliente/alterar/${cliente.getId()}">Alterar</a>
					</td>
					<td>
						<a href="#" onclick="remover('Deseja Remover?', '${pageContext.request.contextPath}/cliente/remover/${cliente.getId()}')">Remover</a>
					</td>
				</tr>
            </c:forEach>
            
    </table>
</div>
</body>
</html>