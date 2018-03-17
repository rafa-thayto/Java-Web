<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuário</title>
</head>
<body>
	
	<form action="/cadastrar" method="POST">
		
		<label for="nome">Nome</label>
		<input type="text" name="nome" id="nome">
		<label for="email">Email</label>
		<input type="email" name="email" id="email">
		<label for="dataNascimento">Data de nascimento</label>
		<input type="date" name="dataNascimento" id="dataNascimento">
		<label for="senha">Senha</label>
		<input type="password" name="senha" id="senha">
		
		<button type="submit">Cadastrar</button>
		
	</form>
	
</body>
</html>