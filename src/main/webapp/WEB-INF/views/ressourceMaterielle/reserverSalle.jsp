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
				<div class="col-md-5">
					<h2>Réserver une salle</h2>
					<table>
						<tr>
							<td style="font-weight: bold;">Coût (par jour)</td>
							<td>${salle.cout}</td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Nombre de places</td>
							<td>${salle.utilisateurMax}</td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Adresse postale</td>
							<td>${salle.adresse}</td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Contact administratif</td>
							<td>${salle.contact}</td>
						</tr>					
					</table>
				</div>
				<div class="col-md-5">
					<form method="POST">
						<h2>Saisir les dates</h2>
						<p>TODO : afficher calendrier de dispo</p>
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