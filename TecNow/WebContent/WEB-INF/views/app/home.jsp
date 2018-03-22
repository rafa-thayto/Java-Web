<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-BR">
<head>
	<c:import url="../templates/header.jsp"></c:import>
	<c:import url="../templates/css-imports.jsp"></c:import>
	<title>Home | TecNow Brasil</title>
</head>
<body class="h-100vh">

	<div class="wrapper">
		<div class="col-md-12">
		
			<div class="tab__group">
				<a href="animes" class="tab__item tab__item--active">Lista de Animes</a>
				<a href="jogos" class="tab__item tab__item--active">Lista de Jogos</a>
				<a href="animes/cadastro" class="tab__item tab__item--active">Cadastro de Animes</a>
				<a href="jogos/cadastro" class="tab__item tab__item--active">Cadastro de Jogos</a>
				
				<c:url value="/user/logout" var="userLogout"></c:url>
				<a href="${ userLogout }" class="tab__item">Sair</a>
			</div>

		</div>
	</div>

	<c:import url="../templates/js-imports.jsp"></c:import>
</body>
</html>