<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>Gestion des salles</h2>
		<table>
			<thead>
				<tr>
					<td>Id</td>
					<td>Coût (par jour)</td>
					<td>Disponibilité</td>
					<td>Nombre de places</td>
					<td>Adresse postale</td>
					<td>Contact administratif</td>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listSalle}" var="salle">
					<td>${salle.id}</td>
					<td>${salle.cout}</td>
					<td>${salle.disponibilite}</td>
					<td>${salle.places}</td>
					<td>${salle.adresse}</td>
					<td>${salle.contact}</td>
					<td>TODO</td>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>