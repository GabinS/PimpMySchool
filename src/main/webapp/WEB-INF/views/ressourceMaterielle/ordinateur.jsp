<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="../style.jsp" />
<title>Ordinateur</title>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>Ordinateurs</h2>

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Processeur</th>
							<th scope="col">RAM</th>
							<th scope="col">Disque Dur</th>
							<th scope="col">Date d'achat</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listordinateur}" var="ordi">
							<tr>
								<td>${ordi.nom}</td>
								<td>${ordi.processeur}</td>
								<td>${ordi.ram}</td>
								<td>${ordi.disqueDur}</td>
								<fmt:formatDate var="date" pattern="yyyy-MM-dd"
									value="${ordi.dateAchat}" />
								<td>${date}</td>
								<td>
									<a href="/PimpMySchool/ordinateur/modifier/${ordi.id}">Edit</a>
									<a href="/PimpMySchool/ordinateur/supprimer/${ordi.id}">X</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<a href="/PimpMySchool/ordinateur/ajouter">Ajouter un ordinateur</a>
				
				<br/><br/>
				
				<h4>Réservations</h4>
										
				<c:forEach items="${listordinateur}" var="ordi">		
						
					<br/>
						
					<u>${ordi.nom}</u>
					
					<br/><br/>
					
					<div class="col-md-6">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Date début</th>
								<th scope="col">Date de fin</th>
								<th scope="col">Actions</th>
							</tr>
						</thead>
						<tbody>				
							<c:forEach items="${ordi.listDisponibilite}" var="dispo">
								<tr>
									<fmt:formatDate var="dateDebut" pattern="yyyy-MM-dd"
										value="${dispo.dateDebut}" />
									<td>${dateDebut}</td>	
									<fmt:formatDate var="dateFin" pattern="yyyy-MM-dd"
										value="${dispo.dateFin}" />
									<td>${dateFin}</td>		
									<td>
										<a href="/PimpMySchool/dispo/modifier/${ordi.id}/${dispo.id}/true">Edit</a>
										<a href="/PimpMySchool/dispo/supprimer/${ordi.id}/${dispo.id}">X</a>
									</td>					
								</tr>
							</c:forEach>	
						</tbody>
					</table>
					</div>
					<a href="/PimpMySchool/dispo/ajouter/${ordi.id}/true">Ajouter une réservation</a>
					<div class="col-md-6"></div>
					
				</c:forEach>			
				
				<p>${error}</p>		
			</div>
		</div>
	</div>
</body>
</html>