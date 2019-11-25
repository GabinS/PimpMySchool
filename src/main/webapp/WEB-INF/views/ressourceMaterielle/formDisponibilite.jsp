<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="../style.jsp" />
<title>Réservations</title>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div class="container">		
		<div class="row">
			<div class="col-md-12">
			
				<br/>
				
				<h4>Défition des réservations de la ressource matérielle <u>${ordi.nom}</u>.</h4>

				<div style="color: red" >${error }</div>

				<br/><br/>
	
				<form method="POST">
					<div class="form-group row">
						<label for="dateDebut" class="col-sm-4 col-form-label">Date début réservation</label>
						<div class="col-sm-8">
							<fmt:formatDate var="varDateDebut" pattern="yyyy-MM-dd" value="${dispo.dateDebut}" />
							<input type="date" class="form-control" value="${varDateDebut}"
								name="dateDebut" id="dateDebut">
						</div>
						
						<br/><br/>
						
						<label for="dateFin" class="col-sm-4 col-form-label">Date fin réservation</label>
						<div class="col-sm-8">
							<fmt:formatDate var="varDateFin" pattern="yyyy-MM-dd" value="${dispo.dateFin}" />
							<input type="date" class="form-control" value="${varDateFin}"
								name="dateFin" id="dateFin">
						</div>
						
						<div class="col-sm-4"></div>
						<div class="col-sm-4" style="padding-top : 15px;">									
							<button type="submit" class="btn btn-dark">Valider</button>
						</div>
					</div>				
				</form>
			</div>
					
			<br/><br/>
	
			<div class="col-md-8">
									
				<p>Liste des réservations associés à cet ordinateur</p>
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
			<div class="col-md-6"></div>
					
		</div>
	</div>
</body>
</html>