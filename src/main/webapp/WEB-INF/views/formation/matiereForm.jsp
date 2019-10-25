<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="../style.jsp" />
<title>${title}</title>
</head>
<body>
	<jsp:include page="../menu.jsp" />
	
	
	
	<div class="container">
	
		<h1>${title}</h1>
	
		<div class="row">
			<div class="col-md-4 col-xs-12">
				<jsp:include page="listMatiere.jsp" />
			</div>
			<div class="col-md-8 col-xs-12">
				<form>
				  <div class="form-group">
				    <label for="exampleInputEmail1">Titre</label>
				    <input type="text" class="form-control" name="titre" required="required" value="${matiere.title}">
				  </div>
				  <div class="form-group">
				    <label for="exampleFormControlTextarea1">Prérequis</label>
				    <textarea class="form-control" name="prerequis" rows="3">${matiere.prerequis}</textarea>
				  </div>
				  <div class="form-group">
				    <label for="exampleFormControlTextarea1">Contenu</label>
				    <textarea class="form-control" name="contenu" rows="3">${matiere.contenu}</textarea>
				  </div>
				  <div class="form-group">
				    <label for="exampleFormControlTextarea1">Objectifs</label>
				    <textarea class="form-control" name="objectifs" rows="3">${matiere.objectifs}</textarea>
				  </div>
				  <div class="form-group">
				    <label for="exampleFormControlTextarea1">Unités d'enseignements</label>
				    <select multiple class="form-control" id="exampleFormControlSelect2" name="listUniteEnseignement">
				      <option>1</option>
				      <option>2</option>
				      <option>3</option>
				      <option>4</option>
				      <option>5</option>
				    </select>
				  </div>
				  <button type="submit" class="btn btn-lg btn-success center-block px-12">Ajouter la matière</button>
				</form>
			</div>
		</div>
		
	</div>
	

</body>
</html>