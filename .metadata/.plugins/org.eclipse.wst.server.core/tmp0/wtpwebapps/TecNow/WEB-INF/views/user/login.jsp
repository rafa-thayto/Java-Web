<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:import url="../templates/header.jsp"></c:import>
	<c:import url="../templates/css-imports.jsp"></c:import>
	<title>Login | TecNow Brasil</title>
</head>
<body>
	
	<div class="wrapper row">
		<div class="col-sm-12 col-md-8">
		
		<a class="active"> Sign In </h2>

			<!-- Form login -->
			<div id="login">

				<c:url value="/TecNow/user/auth" var="urlAuthUser"></c:url>
				<form action="${ urlAuthUser }" method="POST">

					<!-- Input Email -->
					<div class="input-group mb-3">
						<label for="inputPassword"></label>
						<div class="input-group-prepend">
							<span class="input-group-text">
								<i class="fas fa-envelope"></i>
							</span>
						</div>
						<input type="email" name="password" id="inputPassword" class="form-control">
					</div> <!-- End Input Email -->

					<!-- Input Password -->
					<div class="input-group mb-3">
						<div class="input-group-prepend">
							<span class="input-group-text">
								<i class="fas fa-lock"></i>
							</span>
						</div>
						<input type="password" name="password" id="name" class="form-control">
					</div> <!-- End Input Password -->
					
				</form>
			</div> <!-- End Form Login -->
		
		</div> <!-- End col-sm-12 col-md-8 -->
	</div> <!-- End Wrapper -->	
	
	<c:import url="../templates/js-imports.jsp"></c:import>
</body>
</html>