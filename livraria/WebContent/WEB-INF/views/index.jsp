<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="cssRoot" value="/assets/css"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ cssRoot }/style.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Abriu o index pelo controller</h1>
	
	<a href="/livraria/usuario/login">Login</a>
	<a href="/livraria/usuario/novo">Cadastrar</a>
</body>
</html>