<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pt-BR">
<head>
	<c:import url="../../templates/header.jsp"></c:import>
	<c:import url="../../templates/css-imports.jsp"></c:import>
	<title>Jogos Cadastro | TecNow Brasil</title>
</head>
<body class="h-100vh">

	<div class="wrapper">
		<div class="col-sm-12 col-md-10 col-lg-7 wrapper__content">
		
			<div id="games">
			
				<div class="tab__group">
					<c:url value="/app/animes/cadastro" var="urlAnime" />
					<a href="${ urlAnime }" class="tab__item">Animes</a>
					<c:url value="/app/jogos/cadastro" var="urlGame" />
					<a href="${ urlGame }" class="tab__item tab__item--active">Jogos</a>
				</div>
				
				<c:url value="/app/animes/salvar" var="urlSaveAnime"></c:url>
				<form action="${ urlSaveAnime }" method="POST">
	
					<!-- Input Name -->
					<div class="form-group">
						<label for="inputName">Nome do jogo</label>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">
									<i class="fas fa-gamepad"></i>
								</span>
							</div>
							<input type="text" name="name" id="inputName" class="form-control" placeholder="Nome do jogo">
						</div>
					</div> <!-- End Input Name -->
					
					<!-- Categoria Select -->
					<div class="form-group">
					    <label for="categorySelect">Categoria</label>
					    <div class="input-group">
						    <div class="input-group-prepend">
								<span class="input-group-text">
									<i class="fas fa-trophy"></i>
								</span>
							</div>
						    <select name="category" class="form-control" id="categorySelect">
						      	<option selected disabled>-- Selecione uma categoria --</option>
						      	<option value="TIRO">Tiro</option>
						      	<option value="RPG">RPG</option>
						      	<option value="PLATAFORMA">Plataforma</option>
						      	<option value="HACK_AND_SLASH">Hack and Slash</option>
						      	<option value="OUTRO">Outro</option>
						    </select>
					    </div>
					</div> <!-- End Gender Select -->
					
					<div class="form-group mt-3 mb-3 d-flex justify-content-around">
						<button type="submit" class="btn btn__form btn-success">Cadastrar</button>
						<c:url value="/app/home" var="urlHome" />
						<a href="${ urlHome }" class="btn btn__form btn-success">Home</a>
					</div>
					
				</form>
			</div> <!-- End Games Form -->
			
		</div> <!-- End col-sm-12 col-md-10 col-lg-7 -->
	</div> <!-- End Wrapper -->

	<c:import url="../../templates/js-imports.jsp"></c:import>
</body>
</html>