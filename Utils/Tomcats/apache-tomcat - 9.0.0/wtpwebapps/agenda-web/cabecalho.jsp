<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<img src="imagens/logo-.jpg" width"200px" height="50px" />

<h2>Bem-Vindo - Agenda de Contato</h2>
<p>
	Data:
	<%=new SimpleDateFormat("dd/MM/yyyy"). format(new Date()) %>
</p>

<p>
	Hora:
	<%=new SimpleDateFormat("hh:mm:ss"). format(new Date()) %>
</p>