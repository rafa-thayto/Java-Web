<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%-- Header and CSS imports --%>
	<c:import url="../templates/header.jsp"></c:import>
	<c:import url="../templates/css-imports.jsp"></c:import>
	<link rel="stylesheet" href="../../../assets/css/main.css">
	<title>Cadastre-se | TecNow Brasil</title>
</head>
<body class="h-100vh">
	<div class="wrapper">
		<div class="col-sm-12 col-md-8">
		
			<!-- Form Signup -->
			<div id="signup">
				<c:url value="/TecNow/usuario/salvar" var="urlRegisterUser"></c:url>
				<form action="${ urlRegisterUser }" method="POST">
	
					<!-- Input Name -->
					<div class="form-group">
						<label for="inputName">Nome</label>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">
									<i class="fas fa-user"></i>
								</span>
							</div>
							<input type="text" name="name" id="inputName" class="form-control" placeholder="Nome">
						</div>
					</div> <!-- End Input Name -->

					<!-- Input Email -->
					<div class="form-group">
						<label for="inputEmail">Email</label>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">
									<i class="fas fa-envelope"></i>
								</span>
							</div>
							<input type="email" name="password" id="inputEmail" class="form-control" placeholder="Email">
						</div>
					</div> <!-- End Input Email -->
	
					<!-- Input Password -->
					<div class="form-group">
						<label for="inputPassword">Password</label>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">
									<i class="fas fa-lock"></i>
								</span>
							</div>
							<input type="password" name="password" id="inputPassword" class="form-control" placeholder="********">
						</div>
					</div> <!-- End Input Password -->
					
					<!-- Input Date -->
					<div class="form-group">
						<label for="inputBirthDate">Data de Nascimento</label>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">
									<i class="fas fa-calendar-check"></i>
								</span>
							</div>
							<input type="date" name="birthDate" id="inputBirthDate" class="form-control" placeholder="dd/mm/aaaa">
						</div> 
					</div><!-- End Input Date-->
					
					<!-- Gender Select -->
					<div class="form-group">
					    <label for="genderSelect">Gênero</label>
					    <select class="form-control" id="genderSelect">
					      	<option selected disabled>-- Selecione um Gênero --</option>
					      	<option value="Feminino">Feminino</option>
					      	<option value="Masculino">Masculino</option>
					      	<option value="Outro">Outro</option>
					    </select>
					</div> <!-- End Gender Select -->
					
					<div class="form-group mb-3">
						<button type="submit" class="btn btn-primary">Cadastrar</button>
					</div>
				</form>
			</div> <!-- End Form Signup -->
			
		</div> <!-- End col-sm-12 col-md-8 -->
	</div> <!-- End Wrapper -->
	
	<%-- JavaScript imports --%>
	<c:import url="../templates/js-imports.jsp"></c:import>
</body>
</html>