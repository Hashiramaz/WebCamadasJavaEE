  <?xml version="1.0" encoding="ISO-8859-1" ?>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, model.Pessoa "%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Listagem de Pessoas</title>
	
	</head>	
	
	<body>
	
		<div align = "center">
			<table border ="1">
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Telefone</th>
					<th>...</th>
				</tr>
			<% List<Pessoa> pessoas = (List<Pessoa>) request.getAttribute("listarPessoas"); 
			for (Pessoa p : pessoas){
				%>
				<tr>
					<td>
						<%= p.getId() %>
					</td>
					<td>
						<%= p.getNome() %>
					</td>
					<td>
						<%= p.getEmail() %>
					</td>
					<td>
						<%= p.getTelefone() %>
					</td>
					<td>
						<a href="ExcluirPessoaServlet?id=<%= p.getId() %>">Excluir</a>
					</td>
				</tr>
					<%
					}
			%>
			</table>		
		</div>


	<a href ="index.jsp">Home Page</a>
	</body>
</html>

