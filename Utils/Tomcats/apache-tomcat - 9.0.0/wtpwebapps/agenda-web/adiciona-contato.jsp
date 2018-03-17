<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="senai"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda - Cadastro de Contatos</title>
<link rel="stylesheet" href="css/jquery-ui.min.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<form action="adicionaContato" method="post">
		Nome: <input type="text" name="nome" /> <br> <br> E-mail: <input
			type="text" name="email" /> <br> <br> Endereço: <input
			type="text" name="endereco" /> <br> <br> Data de
		Nascimento:
		<senai:campoData id="dataNascimento" />
		<input type="submit" value="Salvar" /> <br> <br>
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>
