<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<jsp:include page="style.jsp" />
		<title>Formation - ${ formation.libelle }</title>
	</head>
	<body>
		<h1>Page de la formation ${ formation.libelle }</h1>
	
		<h2>Liste des élèves :</h2>
		<c:forEach items="${ formation.listStagiaire }" var="stagiaire">
			<tr>
				<td>${ stagiaire.id } - ${ stagiaire.nom } ${ stagiaire.prenom }</td>
				<td>Enlever</td>
			</tr>
		</c:forEach>
		
		
		<h2>Liste des matières</h2>
		<c:foreach items="${ formation.listMatiere }" var="matiere">
			<tr>
				<td>${ matiere.id } - ${ matiere.titre }</td>
				<td>Enlever</td>
			</tr>
		</c:foreach>
		<p> Ajouter une matière existante : 
		<input type=text list=browsers >
			<datalist id=browsers >
			   <option> Google
			   <option> IE9
			</datalist>
		<input type="button" value="Ajouter">
		</p>
		
		<h4><a href="">Planning</a></h2>
	</body>
</html>