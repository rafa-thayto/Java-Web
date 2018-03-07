<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
		<title>Agenda - Cadastro de Contatos</title>
	</head>
	<body>
	<c:import url="cabecalho.jsp" />
		<form action="adicionaContato" method="post">
			Nome:
			<input type="text" name="nome" /> <br><br>
			E-mail:
			<input type="text" name="email" /> <br><br>
			Endereço:
			<input type="text" name="endereco" /> <br><br>
			Data de Nascimento:
 			<input type="text" name="dataNascimento" /> <br><br>
			<input type="submit" value="Salvar" /> <br><br>
		</form>
	<c:import url="rodape.jsp" />
	</body>
</html>