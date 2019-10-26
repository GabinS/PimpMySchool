<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<div class="col-md-4">
					<h2>Réserver une salle</h2>
					<table>
						<tr><td>${salle.id}</td></tr>
						<tr><td>${salle.cout}</td></tr>
						<tr><td>${salle.disponibilite}</td></tr>
						<tr><td>${salle.places}</td></tr>
						<tr><td>${salle.adresse}</td></tr>
						<tr><td>${salle.contact}</td></tr>
					</table>
				</div>
				<div class="col-md-4">
					<form method="POST">
						<h2>Saisir les dates</h2>
						<table>
							<tr>
								<td><label for="dateDepart">A partir du </label></td>
								<td><input type="date" name="dateDepart"></td>
							</tr>
							<tr>
								<td><label for="dateFin">Jusqu'au </label></td>
								<td><input type="date" name="dateFin"></td>
							</tr>
							<tr>
								<td><input type="submit" value="Valider" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>