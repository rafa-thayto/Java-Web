<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

	<!-- cria o DAO -->
	<jsp:useBean id="dao" 
	class="br.senai.sp.dao.LivroDAO" />
	<table>
		<!-- percorre livros 
		montando as linhas da tabela -->
		<c:forEach var="livro" 
		items="${dao.lista}">
			 <tr>
				<td>${livro.nome}</td>
				<td>${livro.autor}</td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp"></c:import>

</body>
</html>
