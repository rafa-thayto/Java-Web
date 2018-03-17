<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Seja bem vindo...</title>
</head>
<body>

<%-- declara uma variável do tipo String --%>
<% String mensagem = "Seja bem vindo ao nosso sistema de agenda !"; %>
<%=mensagem %>
<br /> <br />

<%=new SimpleDateFormat("dd/MM/yyyy").format(new Date())%>
<br /> <br />

<%=new SimpleDateFormat("hh:mm:ss").format(new Date()) %>
</body>
</html>