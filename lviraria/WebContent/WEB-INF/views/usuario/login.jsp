<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- verificar se foram enviados erros --%>
<c:if test="${not empty erros}">
	<div style="background-color:red; color:white">
		<%-- Faz um laço percorrendo cada erro --%>
		<c:forEach items="${erros }" var="erro">
			<p>${erro }</p>
		</c:forEach>
	
	</div>
</c:if>



	<form method="post" action="/livraria/autenticar">
	
		
			
			<label>
				Email
				<input type="email" name="email">
			</label> <br>
			
			
			<label>
				Senha
				<input type="password" name="senha">
			</label> <br>
			
			
			<button type="submit">Salvar</button>
			
			
			

	
	
	</form>

</body>
</html>