<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="../style.jsp" />
<title>Liste des Videoprojecteurs</title>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<br />
				<h2>Gestion des VideoProjecteurs</h2>
				<table>
					<thead style="font-weight: bold;">
						<tr>
							<td>Nom&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>Résolution&nbsp;&nbsp;&nbsp;</td>
							<td>Durée de vie de la lampe&nbsp;&nbsp;&nbsp;</td>
							<td>Type de lampe&nbsp;&nbsp;&nbsp;</td>
							<td>Date d'achat&nbsp;&nbsp;&nbsp;</td>
							<td>Actions</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listVideoProjecteur}" var="videoProjecteur">
							<tr>
								<td style="border-left: 1px solid black; padding: 5px;">${videoProjecteur.nom}</td>
								<td style="border-left: 1px solid black; padding: 5px;">${videoProjecteur.resolution}</td>
								<td style="border-left: 1px solid black; padding: 5px;">${videoProjecteur.dureeVieLampe}</td>
								<td style="border-left: 1px solid black; padding: 5px;">${videoProjecteur.typeLampe}</td>
								<td><fmt:formatDate var="dateAchat" pattern="dd/MM/yyyy"
										value="${videoProjecteur.dateAchat}" /> ${dateAchat}</td>
								<td>
									<div class="dropdown">
										<button class="btn btn-primary dropdown-toggle" type="button"
											id="dropdownMenuButton" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false">Plus</button>
										<div class="dropdown-menu"
											aria-labellledby="dropdownMenuButton">
											<a class="dropdown-item"
												href="/PimpMySchool/videoprojecteur/modifier/${videoProjecteur.id}">Modifier</a>
											<a class="dropdown-item"
												href="/PimpMySchool/videoprojecteur/supprimer/${videoProjecteur.id}">Supprimer</a>
											<a class="dropdown-item"
											href="#">Utiliser le matériel</a>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="/PimpMySchool/videoprojecteur/ajouter">Ajouter un
					nouveau VidéoProjecteur</a>
			</div>
		</div>
	</div>
</body>
</html>