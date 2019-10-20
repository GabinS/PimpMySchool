<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="../style.jsp" />
<title>${title}</title>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	
	<div class="container">
		
		<h1>${title}</h1>
		<form>
		  <div class="form-group">
		    <label for="exampleInputEmail1">Titre</label>
		    <input type="text" class="form-control" name="titre">
		  </div>
		  <div class="form-group">
		    <label for="exampleFormControlTextarea1">Prérequis</label>
		    <textarea class="form-control" name="prerequis" rows="3"></textarea>
		  </div>
		  <div class="form-group">
		    <label for="exampleFormControlTextarea1">Contenu</label>
		    <textarea class="form-control" name="contenu" rows="3"></textarea>
		  </div>
		  <div class="form-group">
		    <label for="exampleFormControlTextarea1">Objectifs</label>
		    <textarea class="form-control" name="objectif" rows="3"></textarea>
		  </div>
		  <button type="submit" class="btn btn-primary">Valider</button>
		</form>
		
	</div>
	

</body>
</html>