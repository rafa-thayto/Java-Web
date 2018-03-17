<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- Verificando se foram eviados erros --%>
	<c:if test="${ not empty erros }">
		<div style="background-color: red; color: white;">
			<c:forEach items="${ erros }" var="erro">
				<p>${ erro }</p>
			</c:forEach>
		</div>
	</c:if>
	
	<form method="POST" action="/livraria/autenticar">
		<label>
			Email
			<input type="email" name="email">
		</label>
		<label>
			Senha
			<input type="password" name="senha">
		</label>
		<input type="submit">
	</form>
</body>
</html>