<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="/livraria/usuario/salvar">
	
				
			<label>
				Nome
				<input type="text" name="nome">
			</label> <br>
		
		
		
			<label>
				Sobrenome
				<input type="text" name="sobrenome">
			</label> <br>
	
			<label>
				Data nascimento
				<input type="date" name="dataNascimento">
			</label> <br>
			
			<label>
				Email
				<input type="email" name="email">
			</label> <br>
			
			
			<label>
				Senha
				<input type="password" name="senha">
			</label> <br>
			
			<label>
				Confirmar senha
				<input type="password">
			</label> <br>
			
			<button type="submit">Salvar</button>
			
			
			

	
	
	</form>



</body>
</html>