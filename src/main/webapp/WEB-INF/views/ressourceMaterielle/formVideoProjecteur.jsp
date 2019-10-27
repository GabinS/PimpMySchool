<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<jsp:include page="../style.jsp" />
<title>Ajouter un VideoProjecteur</title>
</head>

<body>
	<jsp:include page="../menu.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<h2>Creer un nouveau vidéoprojecteur</h2>
				<form method="POST">
					<div class="form-group row">
						<label for="resolution" class="col-sm-2 col-form-label">Nom
							du Vidéoprojecteur</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="nom"
								value="${videoProjecteur.nom}"
								placeholder="ex: ACER P1250" maxlength="30"/>
						</div>
					</div>
					<div class="form-group row">
						<label for="resolution" class="col-sm-2 col-form-label">Resolution
							du videoprojecteur </label>
						<div class="col-sm-10">
							<input type="number" class="form-control" name="resolution"
								value="${videoProjecteur.resolution}" placeholder="ex: 1080" maxlength="5"/>
						</div>
					</div>
					<div class="form-group row">
						<label for="dureeVieLampe" class="col-sm-2 col-form-label">Duree
							de vie de la lampe en nombre d'heure </label>
						<div class="col-sm-10">
							<input type="number" class="form-control" name="dureeVieLampe"
								value="${videoProjecteur.dureeVieLampe}"  maxlength="5"/>
						</div>
					</div>
					<div class="form-group row">
						<label for="typeLampe" class="col-sm-2 col-form-label">Type
							de lampe presente </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="typeLampe"
								value="${videoProjecteur.typeLampe}"
								placeholder="ex: LED, LASER" maxlength="6"/>
						</div>
					</div>
					<div class="form-group row">
						<label for="dateAchat" class="col-sm-2 col-form-label">Date
							d'achat </label>
						<div class="col-sm-10">
							<fmt:formatDate var="dateD" pattern="yyyy-MM-dd"
								value="${videoProjecteur.dateAchat}" />
							<input type="date" class="form-control" name="dateAchat"
								required="required" value="${dateD}"/>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Valider</button>
				</form>
				<br /> <a href="/PimpMySchool/videoprojecteur"><button
						type="submit" class="btn btn-primary">Annuler</button></a>
			</div>
		</div>
	</div>
</body>

</html>