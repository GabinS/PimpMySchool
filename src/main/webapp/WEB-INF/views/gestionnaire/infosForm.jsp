<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form method="POST" class="container">

	<div class="form-group">
	  <label for="exampleInputEmail1">Pseudo</label>
	  <input type="text" class="form-control" name="username" required="required" value="${ressourceHumaine.username}">
	</div>
	
	<div class="form-group">
	  <label for="exampleInputEmail1">MDP</label>
	  <input type="text" class="form-control" name="password" required="required" value="${ressourceHumaine.password}">
	</div>
	
	<div class="form-group">
	  <label for="exampleInputEmail1">Nom</label>
	  <input type="text" class="form-control" name="nom" required="required" value="${ressourceHumaine.nom}">
	</div>
	
	<div class="form-group">
	  <label for="exampleInputEmail1">Prenom</label>
	  <input type="text" class="form-control" name="prenom" required="required" value="${ressourceHumaine.prenom}">
	</div>
	
	<div class="form-group">
	  <label for="exampleInputEmail1">Adresse</label>
	  <input type="text" class="form-control" name="adresse" required="required" value="${ressourceHumaine.adresse}">
	</div>
	
	<div class="form-group">
	  <label for="exampleInputEmail1">Mail</label>
	  <input type="text" class="form-control" name="mail" required="required" value="${ressourceHumaine.mail}">
	</div>
	
	<div class="form-group">
	  <label for="exampleInputEmail1">Telephone</label>
	  <input type="text" class="form-control" name="telephone" required="required" value="${ressourceHumaine.telephone}">
	</div>
	
	<c:if test="${ressourceHumaine != null}">
		<div class="row">
			<div class="col-md-6 col-sm-12 mb-2">
				<button type="submit" class="btn btn-lg btn-block btn-success">Enregistrer les modifications</button>
			</div>
		</div>
	</c:if>
</form>