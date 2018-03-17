<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login no mercado família</title>
</head>
<body>
	<form action="/login" method="POST">
	
		<label for="email">Email</label>
		<input type="email" name="email" id="email" placeholder="Digite seu email">
		<label for="senha">Senha</label>
		<input type="password" name="senha" id="senha" placeholder="Digite sua senha">
		
		<button type="submit">Login</button>
		
	</form>
</body>
</html>