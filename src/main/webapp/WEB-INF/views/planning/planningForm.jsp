<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

			<form method="POST" class="container">
			<!--  <input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" /> -->

				<div class="form-group">
	  				<label for="exampleFormControlTextarea1">Matière</label>
      					<select id="matiere" class="form-control" name="matiere.id">
      					<option>Choisir un matière</option>
      					<c:forEach items="${ matieres }" var="matiere">
        					<option 
        					<c:if test="${ matiere.id == planning.matiere.id }">selected="selected"</c:if>
        					value ="${ matiere.id }">${ matiere.titre }</option>
        				</c:forEach>
      					</select>
				</div>
	
				<div class="form-group">
	  				<label for="exampleFormControlTextarea1">Formation</label>
      					<select id="formation" class="form-control" name="formation.id">
      					<option>Choisir une formation</option>
      					<c:forEach items="${ formations }" var="formation">
        					<option 
        					<c:if test="${ formation.id == planning.formation.id }">selected="selected"</c:if>
        					value ="${ formation.id }">${ formation.libelle }</option>
        				</c:forEach>
      					</select>
				</div>
				<div class="form-group">
	  				<label for="exampleInputEmail1">Date de début :</label>
	  				<fmt:formatDate var="dateD" pattern="yyyy-MM-dd" value="${ planning.dateDebut }" />
	  				<input type="date" class="form-control" name="dateDebut" required="required" value="${dateD}"/>
				</div>
	
				<div class="form-group">
	  				<label for="exampleFormControlTextarea1">Date de fin :</label>
	  				<fmt:formatDate var="dateF" pattern="yyyy-MM-dd" value="${ planning.dateFin }" />
	  				<input type="date" class="form-control" name="dateFin" required="required" value="${dateF}"/>
				</div>
				
	<c:if test="${planning == null}">
		<button type="submit" class="btn btn-lg btn-success btn-block mb-2">Enregistrer le cours</button>
	</c:if>
	<c:if test="${planning != null}">
		<div class="row">
			<div class="col-md-6 col-sm-12 mb-2">
				<button type="submit" class="btn btn-lg btn-block btn-success">Enregistrer les modifications</button>
			</div>
			<div class="col-md-6 col-sm-12 mb-2">
				<a href="../delete/${planning.id}" class="btn btn-lg btn-block btn-danger">Supprimer</a>
			</div>
		</div>
	</c:if>
</form>



