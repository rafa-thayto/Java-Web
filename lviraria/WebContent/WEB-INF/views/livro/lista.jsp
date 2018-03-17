<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Atributo da sessão (pegando) -->

<h1>Autenticado  ${usuario.nome }</h1>

<a href="/livraria/sair">Sair</a>


<ul>
	<c:url value="/app/livro/novo" var="urlNovoLivro"></c:url>
	
	<c:url value="/app/categoria" var="urlCategorias"></c:url>
	
	
	<li>  <a href="${urlNovoLivro}"> Novo Livro</a>	</li>
	<li>  <a href="${urlCategorias}"> Categorias</a>	</li>
</ul>
</body>
</html>