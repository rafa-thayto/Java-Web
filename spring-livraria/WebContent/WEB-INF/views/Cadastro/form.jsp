<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../Templates/head.jsp"></c:import>
<body>

	<c:import url="../Templates/cabecalho.jsp"></c:import>

	<h1>Cadastro de caregorias</h1>
	
	<c:url value="/app/categoria/salvar" var="salvarCategoria"></c:url>
	<form action="${ salvarCategoria }" method="post">
	
	<%-- Campo escondido para guardar o id --%>
	<input type="hidden" value="${ categoria.id }" name="id">
	
		<label>
			Nome:
			<input type="text" name="nome" maxlength="30" value="${ categoria.nome }">
		
		</label>
		
		<button type="submit"> Salvar </button>
	
	</form>

</body>
</html>