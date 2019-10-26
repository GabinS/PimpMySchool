<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<jsp:include page="../style.jsp" />
		<title>Ajout salle</title>
	</head>
	<body>
		<jsp:include page="../menu.jsp" />
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<h2>Créer une nouvelle salle</h2>
					<form method="POST">
						<table>
							<tr>
								<td><label for="cout">Coût (par jour) </label></td>
								<td><input type="number" step="0.01" min="0" name="cout" value="${salle.cout}"></input></td>
							</tr>
							<tr>
								<td><label for="utilisateurMax">Nombre de places </label></td>
								<td><input type="number" name="utilisateurMax" value="${salle.utilisateurMax}"></input></td>
							</tr>
							<tr>
								<td><label for="adresse">Adresse postale </label></td>
								<td><input type="text" name="adresse" value="${salle.adresse}"></input></td>
							</tr>
							<tr>
								<td><label for="contact">Contact administratif </label></td>
								<td><input type="text" name="contact" value="${salle.contact}"></input></td>
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