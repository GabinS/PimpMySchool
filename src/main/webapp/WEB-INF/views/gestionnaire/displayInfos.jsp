<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<jsp:include page="../style.jsp" />
		<title>
		Utilisateur - ${ ressourceHumaine.Nom } 
					  ${ ressourceHumaine.Prenom } 
		</title>
	</head>
	<body>
		<h1>Page d'informations personnelles</h1>
	
		<tr>
			<td>
			<p> Pseudo    : ${ ressourceHumaine.username }</p>
			<p> Nom       : ${ ressourceHumaine.nom } </p>
		    <p> Prenom    : ${ ressourceHumaine.prenom }</p>
			<p> Adresse   : ${ ressourceHumaine.adresse }</p>
			<p> Mail      : ${ ressourceHumaine.mail }</p>
		    <p> Telephone : ${ ressourceHumaine.tel }</p>
			</td>
		</tr>
		<a href="/PimpMySchool/infos/modify/${ressourceHumaine.id}" class="btn btn-lg btn-primary btn-block my-4">Modifier les informations personnelles</a>
	</body>
</html>