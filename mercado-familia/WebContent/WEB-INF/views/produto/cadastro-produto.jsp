<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de produtos</title>
</head>
<body>
	<form action="/cadastroProdutos" method="POST">
	
		<label for="nome">Nome</label>
		<input type="text" name="nome" id="nome">
		<label for="preco">Preço</label>
		<input type="text" name="preco" id="preco">
		<label for="data">Data</label>
		<input type="date" name="data" id="data">
		
		<button type="submit">Cadastrar Produto</button>
		
	</form>
</body>
</html>