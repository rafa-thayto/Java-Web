<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:import url="../templates/header.jsp"></c:import>
	<c:import url="../templates/css-imports.jsp"></c:import>
	<title>Login | TecNow Brasil</title>
</head>
<body class="h-100vh">
	
	<div class="wrapper">
		<div class="col-sm-12 col-md-10 col-lg-7 wrapper__content">
		
			<!-- Form login -->
			<div id="login">
				
				<div class="tab__group">
					<a href="login" class="tab__item tab__item--active">Login</a>
					<a href="signup" class="tab__item">Cadastro</a>
				</div>
				
				<c:url value="/user/auth" var="urlAuthUser"></c:url>
				<form action="${ urlAuthUser }" method="POST">

					<!-- Input Email -->
					<div class="form-group">
						<label for="inputEmail">Email</label>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">
									<i class="fas fa-envelope"></i>
								</span>
							</div>
							<input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email">
						</div>
					</div> <!-- End Input Email -->

					<!-- Input Password -->
					<div class="form-group">
						<label for="inputPassoword">Senha</label>
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">
									<i class="fas fa-lock"></i>
								</span>
							</div>
							<input type="password" name="password" id="inputPassword" class="form-control" placeholder="********">´
						</div>
					</div> <!-- End Input Password -->
					
					<div class="form-group mt-3 mb-3 d-flex justify-content-center">
						<button type="submit" class="btn btn__form btn-success">Login</button>
					</div>
					
				</form>
			</div> <!-- End Form Login -->
		
		</div> <!-- End col-sm-12 col-md-8 -->
	</div> <!-- End Wrapper -->	
	
	<c:import url="../templates/js-imports.jsp"></c:import>
</body>
</html>