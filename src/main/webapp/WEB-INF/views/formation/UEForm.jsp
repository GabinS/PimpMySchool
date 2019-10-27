<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form method="POST" class="container">
	<div class="form-group">
	  <label for="exampleInputEmail1">Titre</label>
	  <input type="text" class="form-control" name="titre" required="required" value="${uniteEnseignement.titre}">
	</div>
	<c:if test="${listMatiere.size() > 0}">
		<div class="form-group">
		  <label for="exampleFormControlTextarea1">Matières associées</label>			
			<select multiple id="listMatiere" class="form-control" name="Matiere.id">
		  		<c:forEach items="${listMatiere}" var="m">
		  			<option value="${m.id}"
			  			<c:if test="${listMatiere_UE.Contains(m)}">
							 selected="selected"
			  			</c:if>
		  			>
		  			${m.titre}
		  			</option>
		  		</c:forEach>
			</select>			
		</div>
	</c:if>
	
	<c:if test="${listFormateur.size() > 0}">
		<div class="form-group">
		  <label for="exampleFormControlTextarea1">Formateurs associées</label>
			
			<select multiple id="listFormateur" class="form-control" name="Formateur.id">
		  		<c:forEach items="${listFormateur}" var="f">
		  			<option value="${f.id}"
			  			<c:if test="${listFormateur_UE.Contains(f)}">
							 selected="selected"
			  			</c:if>
		  			>
		  			${f.prenom} ${f.nom}
		  			</option>
		  		</c:forEach>
			</select>
			
		</div>
	</c:if>
	
	<c:if test="${uniteEnseignement == null}">
		<button type="submit" class="btn btn-lg btn-success btn-block mb-2">Enregistrer l'unité d'enseignement</button>
	</c:if>
	<c:if test="${uniteEnseignement != null}">
		<div class="row">
			<div class="col-md-6 col-sm-12 mb-2">
				<button type="submit" class="btn btn-lg btn-block btn-success">Enregistrer les modifications</button>
			</div>
			<div class="col-md-6 col-sm-12 mb-2">
				<a href="../delete/${uniteEnseignement.id}" class="btn btn-lg btn-block btn-danger">Supprimer</a>
			</div>
		</div>
	</c:if>
</form>