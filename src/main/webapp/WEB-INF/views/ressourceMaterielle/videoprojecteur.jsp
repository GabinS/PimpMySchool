<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="../style.jsp" />
<title>VideoProjecteur</title>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<h2>Gestion des VideoProjecteurs</h2>
				<table>
					<thead style="font-weight: bold;">
						<tr>
							<td>Résolution</td>
							<td>Durée de vie de la lampe</td>
							<td>Type de lampe</td>
							<td>Date d'achat</td>
							<td>Actions</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listVideoProjecteur}" var="videoProjecteur">
							<tr>
								<td>${videoProjecteur.resolution}</td>
								<td>${videoProjecteur.dureeVieLampe}</td>
								<td>${videoProjecteur.typeLampe}</td>
								<td>
								<fmt:formatDate var="dateAchat" pattern="dd/MM/yyyy" value="${videoProjecteur.dateAchat}" />
								${dateAchat}
								</td>
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