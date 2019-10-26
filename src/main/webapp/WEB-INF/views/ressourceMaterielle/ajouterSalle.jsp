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
								<td><input type="text" name="cout"></input></td>
							</tr>
							<tr>
								<td><label for="nombrePlace">Nombre de places </label></td>
								<td><input type="text" name="nbPlace"></input></td>
							</tr>
							<tr>
								<td><label for="adressePostale">Adresse postale </label></td>
								<td><input type="text" name="adressePostale"></input></td>
							</tr>
							<tr>
								<td><label for="contactAdministratif">Contact administratif </label></td>
								<td><input type="text" name="contactAdministratif"></input></td>
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