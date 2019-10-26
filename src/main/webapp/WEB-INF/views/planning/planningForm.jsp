<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

			<form method="POST" class="container">

				<div class="form-group">
	  				<label for="exampleFormControlTextarea1">Matière</label>
      				<select id="inputState" class="form-control">
      				<c:forEach items="${ matieres }" var="matiere">
        				<option>${ matiere.titre }</option>
        			</c:forEach>
      				</select>
				</div>
	
			 	<c:if test="${formation == null}">
				<div class="form-group">
	  				<label for="exampleFormControlTextarea1">Formation</label>
      					<select id="inputState" class="form-control">
      					<c:forEach items="${ formations }" var="formation">
        					<option>${ formation.libelle }</option>
        				</c:forEach>
      					</select>
				</div>
				</c:if> 
 
				<div class="form-group">
	  				<label for="exampleInputEmail1">Date de début :</label>
	  				<input type="date" class="form-control" name="titre" required="required" value="${planning.dateDebut}"/>
				</div>
	
				<div class="form-group">
	  				<label for="exampleFormControlTextarea1">Date de fin :</label>
	  				<input type="date" class="form-control" name="titre" required="required" value="${planning.dateFin}"/>
				</div>
<!-- 				</br>
				<h3>Affectation du matériel</h3>
				<div class="form-row">	
					<div class="form-group col-md-8">			
	  					<label for="exampleFormControlTextarea1">Ordinateur</label>
      					<select id="inputState" class="form-control">
      						<option selected>Pas d'ordinateur</option>
      					<c:forEach items="${ ordinateurs }" var="matiere">
        					<option>${ ordinateur.nom }</option>
        				</c:forEach>
      					</select>
      				</div>
					<div class="form-group col-md-4">			
	  					<label for="exampleFormControlTextarea1">Quantité</label>
      					<select id="inputState" class="form-control">
      						<option selected>0</option>
        					<option>1</option>
        					<option>2</option>

      					</select>
      				</div> 
					<div class="form-group col-md-8">			
	  					<label for="exampleFormControlTextarea1">Vidéoprojecteur</label>
      					<select id="inputState" class="form-control">
      						<option selected>Pas de vidéoprojecteur</option>
      					<c:forEach items="${ videoprojecteur }" var="matiere">
        					<option>${ videoprojecteur.nom }</option>
        				</c:forEach>
      					</select>
      				</div>
					<div class="form-group col-md-4">			
	  					<label for="exampleFormControlTextarea1">Quantité</label>
      					<select id="inputState" class="form-control">
      						<option selected>0</option>
        					<option>1</option>
        					<option>2</option>
      					</select>
      				</div>  
					<div class="form-group col-md-8">			
	  					<label for="exampleFormControlTextarea1">Salle</label>
      					<select id="inputState" class="form-control">
      						<option selected>Pas de salle</option>
      					<c:forEach items="${ salles }" var="matiere">
        					<option>${ salle.nom }</option>
        				</c:forEach>
      					</select>
      				</div>
					<div class="form-group col-md-4">			
	  					<label for="exampleFormControlTextarea1">Quantité</label>
      					<select id="inputState" class="form-control">
      						<option selected>0</option>
        					<option>1</option>
        					<option>2</option>
      					</select>
      				</div>     				
				</div>-->
				

	

	
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



