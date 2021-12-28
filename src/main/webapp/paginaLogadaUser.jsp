<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="models.Usuario"%>
  <%@ page import="java.util.ArrayList"%>
    
  <%
  	ArrayList<Usuario> usuario = (ArrayList<Usuario>) request.getAttribute("nomeLogado");
  
	/*for(int i = 0; i < usuario.size(); i++){
		out.println(usuario.get(i).getNome());
	}*/
			
	
  %>
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
	body{
		font-family: Arial, Helvetica, sans-serif;
		background: rgb(87, 165, 161);
	}
	
	div{
		background-color: rgba(0, 0, 0, 0.9);
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		padding: 80px;
		border-radius: 25px;
		color: white;
	}

	.deslogar{
		text-decoration: none;
		background-color: rgb(96, 130, 223);
		padding: 5px 10px 5px 10px;
		color: rgb(0, 0, 0);
		font-size: 15px;
		font-weight: 700;
		border-radius: 10px;
		cursor: pointer;
	}
	.deslogar:hover {
		background-color: rgb(78, 107, 204);
		cursor: pointer;
	}	
	

</style>
</head>
<body>

	<%
	
		String usuario1 = (String) session.getAttribute("usuario");
		if(usuario1 == null){
			response.sendRedirect("login.html");
			return;
		}
		else {
			
		}
	%>

	<div>
		<% for(int i = 0; i < usuario.size(); i++) { %>
	
			<h1>Olá <%=usuario.get(i).getNome() %>, seja bem vindo </h1> 
			
			<%} %>
			
			<a href="deslogar.jsp" class="deslogar">Deslogar</a>

	</div>
	
</body>
</html>