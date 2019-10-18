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
			</tr>
		</c:forEach>
	</body>
</html>