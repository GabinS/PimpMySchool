<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="../style.jsp" />
<title>Ajouter un VidéoProjecteur</title>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<h2>Créer un nouveau vidéoprojecteur</h2>
				<form method="POST">
					<table>
						<tr>
							<td><label for="resolution">Résolution du
									vidéoprojecteur (ex: 1080p)</label></td>
							<td><input type="number" name="resolution"
								value="${videoProjecteur.resolution}" /></td>
						</tr>
						<tr>
							<td><label for="dureeVieLampe">Durée de vie de la
									lampe en nombre d'heure</label></td>
							<td><input type="number" name="dureeVieLampe"
								value="${videoProjecteur.dureeVieLampe}" /></td>
						</tr>
						<tr>
							<td><label for="typeLampe">Type de lampe présente
									(ex: LED, LASER)</label></td>
							<td><input type="text" name="typeLampe"
								value="${videoProjecteur.typeLampe}" /></td>
						</tr>
						<tr>
							<td><label for="dateAchat">Date d'achat</label></td>
							<td>
								<input type="date" name="dateAchat" value="${videoProjecteur.dateAchat}" />
							</td>
						</tr>
						<tr>
							<td><input type="submit" value="Valider" /></td>
						</tr>
					</table>
				</form>
				<br /> <a href="/PimpMySchool/videoprojecteur"><button>Annuler</button></a>
			</div>
		</div>
	</div>
</body>
</html>