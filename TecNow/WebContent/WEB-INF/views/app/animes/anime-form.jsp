<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-BR">
<head>
	<c:import url="../../templates/header.jsp"></c:import>
	<c:import url="../../templates/css-imports.jsp"></c:import>
	<title>Animes Cadastro | TecNow Brasil</title>
</head>
<body class="h-100vh">

	<div class="wrapper">
		<div class="col-sm-12 col-md-10 col-lg-7 wrapper__content">
			
			<div id="animes">
			
				<div class="tab__group">
					<c:url value="/app/animes/cadastro" var="urlAnime" />
					<a href="${ urlAnime }" class="tab__item tab__item--active">Animes</a>
					<c:url value="/app/jogos/cadastro" var="urlGame" />
					<a href="${ urlGame }" class="tab__item">Jogos</a>
				</div>
				
				<c:url value="/app/jogos/salvar" var="urlSaveGame"></c:url>
				<form action="${ urlSaveGame }" method="POST">
	
					<!-- Input Name -->
					<div class="form-group">
						<label for="inputName">Nome do anime</label>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">
									<i class="fab fa-d-and-d"></i>
								</span>
							</div>
							<input type="text" name="name" id="inputName" class="form-control" placeholder="Nome do anime">
						</div>
					</div> <!-- End Input Name -->
					
					<div class="form-group mt-3 mb-3 d-flex justify-content-center">
						<button type="submit" class="btn btn__form btn-success">Cadastrar</button>
					</div>
					
				</form>
				
			</div> <!-- End animes Form -->
			
		</div> <!-- End col-sm-12 col-md-10 col-lg-7 -->
	</div> <!-- End Wrapper -->

	<c:import url="../../templates/js-imports.jsp"></c:import>
</body>
</html>