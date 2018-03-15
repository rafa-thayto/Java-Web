<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/app/categoria/deletar" var="urlDeletarCategoria"></c:url>
<c:url value="/app/cadastro" var="urlTelaCadastro"></c:url>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista</title>
</head>
<body>

	<c:import url="../Templates/cabecalho.jsp"></c:import>

	<h1>Autenticado</h1>
	
	<h2>Lista de categorias</h2>
	
	<%-- Desenhando a tabela para listar a categorias --%>
	<table>
	
		<thead>
		
			<tr>
			
				<th>Nome</th>
				<th>Ações</th>
				
			</tr>
			
		</thead>
		
		<tbody>
		
			<%-- Gerar o conteúdo para listar as categorias --%>
			
			<c:forEach items="${ categorias }" var="categoria">
			
				<tr>
				
					<td>${ categoria.nome }</td>
					<td><a href="${ urlDeletarCategoria }?id=${ categoria.id }">Deletar</a></td>
					<td><a href="${ urlTelaCadastro }?id=${ categoria.id }">Alterar</a></td>
					
				</tr>
			
			</c:forEach>
			
		</tbody>
	
	</table>
	
</body>
</html>