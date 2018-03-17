<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Categorias de ${usuario.nome}</h1>
	
	
	<c:choose>
		<c:when test="${empty categoria}">
			<c:url value="/app/categoria/salvar" var="urlSalvarCategoria"/>		
		</c:when>	
		<c:otherwise>
			<c:url value="/app/categoria/salvar/${categoria.id}" var="urlSalvarCategoria"/>
		</c:otherwise>
	</c:choose>
	
	<form action="${urlSalvarCategoria}" method="post">
	<%-- Cria um campo hidden para armazenar o id da categoria alterada --%>
		<label>
			Nome
			<input type="text" name="nome" value="${categoria.nome }">
		</label>
		<button type="submit">Salvar</button>
	</form>
	<br>
	
	<%-- Tabela de categorias --%>
	<table>
		<thead>
			<tr>
				<td></td>
				<td></td>
			</tr>
		</thead>
		<tbody>
		
		
			<c:forEach items="${categorias}" var="categoria">
			<tr>
				<td>${categoria.nome }</td>
				<td>
					<c:url value="/app/categoria/deletar?id=" var="urlDeletar"></c:url>
					<c:url value="/app/categoria?id=" var="urlEditar"></c:url>
					<a href="${urlEditar }${categoria.id}">Editar</a>
					<a href="${urlDeletar }${categoria.id}">Del</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>