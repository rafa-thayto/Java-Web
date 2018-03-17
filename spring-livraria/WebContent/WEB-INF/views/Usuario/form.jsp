<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuários</title>
</head>
<body>

	<form method="post" action="/spring-livraria/usuario/salvar">
	
		<label>
			Nome:
			<input type="text" name="nome" maxlength="30">
		
		</label><br/>
		
		<label>
			Sobrenome:
			<input type="text" name="sobrenome" maxlength="50">
		
		</label><br/>
		
		<label>
			Data de nascimento:
			<input type="date" name="dataNascimento">
		
		</label><br/>
		
		<label>
			E-mail:
			<input type="email" name="email">
		
		</label><br/>
		
		<label>
			Senha:
			<input type="password" name="senha">
		
		</label><br/>
		
		<button type="submit">Salvar</button>
	
	</form>

</body>
</html>