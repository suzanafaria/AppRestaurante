<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Pedido Listagem</title>
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

  <h2><b>Lista de Pedidos</b></h2>
  	<a href="/">Voltar ao Menu</a>
  	<br>
  	<br>
	<a href="/pedido/inserir">Realizar novo Pedido</a>

	<hr>


 	<table border>
            <tr><th>Número</th><th>Valor Total</th><th>Forma de Pagamento</th><th>Cliente</th><th>Produtos</th><th>Alterar</th><th>Excluir</th></tr>
            <c:forEach items="${pedidos}" var="pedido">
            	<tr>
					<td>${pedido.getNumero()}</td>
					<td>${pedido.getValorTotal()}</td>
					<td>${pedido.getFormaPagamento()}</td>
					<td>${pedido.getCliente().getNome()}</td>
					<td>
						<a href="${pageContext.request.contextPath}/produto/porPedido/${produto.getId()}">Produtos</a> 
					</td>
					<td>
						<a href="${pageContext.request.contextPath}/pedido/alterar/${pedido.getId()}">Alterar</a>
					</td>
					<td>
						<a href="#" onclick="remover('Deseja Remover?', '${pageContext.request.contextPath}/pedido/remover/${pedido.getId()}')">Remover</a>
					</td>
				</tr>
            </c:forEach>
            
    </table>
</div>
</body>
</html>