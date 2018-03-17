<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- cabeçalho da taglib core -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Contatos</title>
</head>
<body>
	<!-- cria um instancia de ContatoDao() -->
	<jsp:useBean 
	id="dao" class="br.senai.sp.informatica.agenda.dao.ContatoDao"/>
	
	<table border="1" style="border-collapse: collapse;">
		<tr>
		<th>Nº</th>
		<th>Nome</th>
		<th>E-mail</th>
		<th>Endreço</th>
		<th>Data de Nascimento</th>
		</tr>
		
		<c:forEach var="contato" items="${dao.lista }" varStatus="id">
		<tr bgcolor="#${id.count % 2 == 0 ? 'AAEE88' : 'CCC'} ">
	        <td>${id.count }</td>	
			<td>${contato.nome}</td>
			<td>
			<c:if test="${not empty contato.email}">
				<a href="mailto:${contato.email }">${contato.email }</a>
			</c:if>
			<c:if test="${empty contato.email }">
			E-mail não informado
			</c:if>
			</td>
			<td>${contato.endereco}</td>
			<td>
			
			<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy	"/>
			
			</td>
		
		</tr>
		</c:forEach>
		
		
	</table>


</body>
</html>