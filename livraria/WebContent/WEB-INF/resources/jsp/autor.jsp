<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	
		
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<title>Livraria-Autor</title>
	</head>
	
	<body class="container">
	
	
		<div class="card text-center" >
	  		<div class="card-body" >
			    <h4 class="card-title" >Cadastro de Autor</h4>
			</div>
		</div>
		
		<br/>
		
		<form action="<c:url value="/autor" />" method="POST" >	
		

		<div class="form-group">
			<label for="nome">Nome</label>
			<input id="nome" class="form-control" name="nome" required="required" placeholder="Seu Nome Completo">	
		</div>
		
		<div class="form-group">
			<label for="email">Email</label>
			<input type="email" id="email" class="form-control" name="email" required="required" placeholder="Seu email">	
		</div>
		
		<div class="form-group">
			<label for="dataNascimento">Data de Nascimento</label>
			<input type="date" pattern="dd/MM/yyyy" id="dataNascimento" class="form-control" name="dataNascimento" required="required">	
		</div>
		
		<div class="form-group">
			<label for="miniCurriculo">Mini Currículo</label>
			<textarea rows="3" id="miniCurriculo" class="form-control" 
			name="miniCurriculo"></textarea>	
		</div>
		
		<input type="submit" class="btn btn-primary" value="Salvar">
		
		</form>
		
		<br/>
		
		<div class="card text-center" >
	  		<div class="card-body" >
			    <h4 class="card-title" >Autores</h4>
			</div>
		</div>
	
		<br/>
		
		<table class="table table-striped table-bordered  table-hover">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Email</th>
					<th>Data Nascimento</th>
					</tr>
			</thead>
			<tbody>
								
				<c:forEach items="${autores}" var="at">
					<tr>
						<td>${at.nome}</td>
						<td>${at.email}</td>
						
						<td>
						<fmt:parseDate  value="${at.dataNascimento}"  type="date" pattern="yyyy-MM-dd" var="parsedDate" />
						<fmt:formatDate value="${parsedDate}" type="date" pattern="dd/MM/yyyy" />
						
					</tr>	
				</c:forEach>
			</tbody>
		</table>
		
	</body>
</html>