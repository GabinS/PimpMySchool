<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form method="POST" class="container">
	<div class="form-group">
		<label for="exampleInputEmail1">Libelle</label> <input type="text"
			class="form-control" name="libelle" required="required"
			value="${formation.libelle}">
	</div>

	<div class="form-group">
		<label for="exampleInputEmail1">Gestionnaire</label> <input
			type="text" class="form-control" name="gestionnaire"
			required="required" value="${formation.gestionnaire.nom}">
	</div>

	<div class="list-group">
		<label for="exampleInputEmail1">Mati�res</label>
		<c:if test="${formation.listMatiere != null}">
			<c:forEach items="${formation.listMatiere}" var="m">
				<a
					class="list-group-item list-group-item-action list-group-item-light">
					${m.titre} </a>
			</c:forEach>
		</c:if>
	</div>



	<c:if test="${formation == null}">
		<button type="submit" class="btn btn-lg btn-success btn-block mb-2">Enregistrer
			la formation</button>
	</c:if>
	<c:if test="${formation != null}">
		<div class="row">
			<div class="col-md-6 col-sm-12 mb-2">
				<button type="submit" class="btn btn-lg btn-block btn-success">Enregistrer
					les modifications</button>
			</div>
			<div class="col-md-6 col-sm-12 mb-2">
				<a href="../delete/${formation.id}"
					class="btn btn-lg btn-block btn-danger">Supprimer</a>
			</div>
		</div>
	</c:if>
</form>