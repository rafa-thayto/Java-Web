<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Categorias de ${ usuario.nome }</h1>
	<a href="/livraria/app/">Voltar para pagina principal</a>
	<c:url value="/app/categoria/salvar" var="urlSalvarCategoria" />
	<form action="${ urlSalvarCategoria }" method="POST">
		<%-- Cria um campo hidden para armazenar o id da categoria alterada --%>
		<input type="hidden" name="id" value="${ categoria.id }">
		<label>
			Nome
			<input type="text" name="nome" value="${ categoria.nome }">
		</label>
		<button type="submit">Salvar</button>
	</form>
	<br>
	<%-- Tabela de categorias --%>
	<table>
		<thead>
			<tr>
				<td>Nome</td>
				<td>Ações</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ categorias }" var="categoria">
				<tr>
					<td>${ categoria.nome }</td>
					<td>
						<c:url value="/app/categoria" var="urlEditar" />
						<a href="${ urlEditar }?id=${ categoria.id 	}">Editar</a>
						
						<c:url value="/app/categoria/deletar" var="urlDeletar" />
						<a href="${ urlDeletar }?id=${ categoria.id }">Remover</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>