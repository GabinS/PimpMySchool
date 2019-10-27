<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="../style.jsp" />
<title>Configuration Ordinateur</title>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<h2>Configurer ordinateur</h2>

				<form method="POST">
					<div class="form-group row">
						<label for="nom" class="col-sm-2 col-form-label">Nom</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" value="${ordi.nom}" name="nom"
								id="nom">
						</div>
					</div>
					<div class="form-group row">
						<label for="processeur" class="col-sm-2 col-form-label">Processeur</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" value="${ordi.processeur}"
								name="processeur" id="processeur">
						</div>
					</div>
					<div class="form-group row">
						<label for="ram" class="col-sm-2 col-form-label">RAM</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" value="${ordi.ram}" name="ram"
								id="ram">
						</div>
					</div>
					<div class="form-group row">
						<label for="disqueDur" class="col-sm-2 col-form-label">Disque Dur</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" value="${ordi.disqueDur}"
								name="disqueDur" id="disqueDur">
						</div>
					</div>
					<div class="form-group row">
						<label for="dateAchat" class="col-sm-2 col-form-label">Date d'achat</label>
						<div class="col-sm-10">
							<fmt:formatDate var="date" pattern="yyyy-MM-dd" value="${ordi.dateAchat}" />
							<input type="date" class="form-control" value="${date}"
								name="dateAchat" id="dateAchat">
						</div>
					</div>
					<button type="submit" class="btn btn-dark">Valider</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>