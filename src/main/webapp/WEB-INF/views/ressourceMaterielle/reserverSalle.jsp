<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<jsp:include page="../style.jsp" />
		<title>Réserver salle</title>
	</head>
	<body>
		<jsp:include page="../menu.jsp" />
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<h2>A propos</h2>
					<table>
						<tr>
							<td style="font-weight: bold;">Coût (par jour): </td>
							<td>${salle.cout}</td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Nombre de places: </td>
							<td>${salle.utilisateurMax}</td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Adresse postale: </td>
							<td>${salle.adresse}</td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Contact administratif: </td>
							<td>${salle.contact}</td>
						</tr>	
						<tr>
							<td style="font-weight: bold;">Dates réservées: </td>
						</tr>
						<tr>
							<c:forEach items="${listDisponibilite}" var="disponibilite">
								<td style="color: #FF0000;">Du ${disponibilite.dateDebut} au ${disponibilite.dateFin}</td>
							</c:forEach>
						</tr>			
					</table>
				</div>
				<div class="col-md-5">
					<form method="POST">
						<h2>Réserver cette salle</h2>
						<table>
							
							<tr>
								<td><label for="dateDebut">A partir du </label></td>
								<td><input type="date" name="dateDebut"></td>
							</tr>
							<tr>
								<td><label for="dateFin">Jusqu'au </label></td>
								<td><input type="date" name="dateFin"></td>
							</tr>
							<tr>
								<td><label for="libelle">Formation </label></td>
								<td>
									<select>
										<c:forEach items="${listFormation}" var="formation">
											<option value="libelle">${formation.libelle}</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td><input type="submit" value="Valider" /></td>
							</tr>
							<tr>
								<td style="font-weight: bold; color: red;">${erreurMessage}</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>