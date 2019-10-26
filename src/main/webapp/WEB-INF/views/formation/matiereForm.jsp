<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
	
	<div class="form-group">
	  <label for="exampleFormControlTextarea1">Unités d'enseignements</label>
	  <select multiple class="form-control" id="exampleFormControlSelect2" name="listUniteEnseignement">

	  </select>
	</div>
	
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