<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form method="POST" class="container">
	<div class="form-group">
	  <label for="exampleInputEmail1">Titre</label>
	  <input type="text" class="form-control" name="titre" required="required" value="${matiere.titre}">
	</div>
	
	<div class="form-group">
	  <label for="exampleFormControlTextarea1">Prérequis</label>
	  <textarea class="form-control" name="prerequis" rows="3">${matiere.prerequis}</textarea>
	</div>
	
	<div class="form-group">
	  <label for="exampleFormControlTextarea1">Contenu</label>
	  <textarea class="form-control" name="contenu" rows="5">${matiere.contenu}</textarea>
	</div>
	
	<div class="form-group">
	  <label for="exampleFormControlTextarea1">Objectifs</label>
	  <textarea class="form-control" name="objectifs" rows="3">${matiere.objectifs}</textarea>
	</div>
		
	<c:if test="${listUE.size() > 0}">
		<div class="form-group">
		  <label for="exampleFormControlTextarea1">Unités d'enseignements associées</label>
		  	<form:select multiple="true" path="listUE" class="form-control" name="listUniteEnseignement">
		  		<form:options items="${listUE}" itemValue="titre" itemLabel="titre"/>
			</form:select>
		</div>
	</c:if>
	
	<c:if test="${listFormateur.size() > 0}">
		<div class="form-group">
		  <label for="exampleFormControlTextarea1">Formateur de la matière</label>
		  	<form:select path="listFormateur" class="form-control" name="formateur">
		  		<form:options items="${listFormateur}" itemValue="prenom" itemLabel="prenom"/>
			</form:select>
		</div>
	</c:if>
	
	<c:if test="${matiere == null}">
		<button type="submit" class="btn btn-lg btn-success btn-block mb-2">Enregistrer la matière</button>
	</c:if>
	<c:if test="${matiere != null}">
		<div class="row">
			<div class="col-md-6 col-sm-12 mb-2">
				<button type="submit" class="btn btn-lg btn-block btn-success">Enregistrer les modifications</button>
			</div>
			<div class="col-md-6 col-sm-12 mb-2">
				<a href="../delete/${matiere.id}" class="btn btn-lg btn-block btn-danger">Supprimer</a>
			</div>
		</div>
	</c:if>
</form>