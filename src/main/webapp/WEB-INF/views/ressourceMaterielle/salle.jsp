<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<jsp:include page="../style.jsp" />
		<title>Salle</title>
	</head>
	<body>
		<jsp:include page="../menu.jsp" />
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<h2>Gestion des salles</h2>
					<table>
						<thead style="font-weight: bold;">
							<tr>
								<td>Coût (par jour)</td>
								<td>Nombre de places</td>
								<td>Adresse postale</td>
								<td>Contact administratif</td>
								<td>Actions</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${listSalle}" var="salle">
								<tr>
									<td>${salle.cout}</td>
									<td>${salle.utilisateurMax}</td>
									<td>${salle.adresse}</td>
									<td>${salle.contact}</td>
									<td>
										<a href="/PimpMySchool/salle/reserver/${salle.id}">Réserver</a>
										<a href="/PimpMySchool/salle/modifier/${salle.id}">Modifier</a>
										<a href="/PimpMySchool/salle/supprimer/${salle.id}">Supprimer</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<a href="/PimpMySchool/salle/ajouter">Ajouter une salle</a>
				</div>
			</div>
		</div>
	</body>
</html>