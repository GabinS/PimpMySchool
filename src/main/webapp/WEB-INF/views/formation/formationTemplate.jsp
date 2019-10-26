<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
		
		<div class="btn-group btn-group-justified my-3 btn-block" role="group" aria-label="Basic example">
			<c:if test="${list.equals('listFormation')}">
		  		<a href="/PimpMySchool/formation" class="btn btn-outline-secondary active">Formations</a>
		  	</c:if>
		  	<c:if test="${!list.equals('listFormation')}">
		  		<a href="/PimpMySchool/formation" class="btn btn-outline-secondary">Formations</a>
		  	</c:if>
		  	<c:if test="${list.equals('listMatiere')}">
		  		<a href="/PimpMySchool/formation/matiere" class="btn btn-outline-secondary active">Matières</a>
		  	</c:if>
		  	<c:if test="${!list.equals('listMatiere')}">
		  		<a href="/PimpMySchool/formation/matiere" class="btn btn-outline-secondary">Matières</a>
		  	</c:if>
		  	<c:if test="${list.equals('listUE')}">
		  		<a href="/PimpMySchool/formation/ue" class="btn btn-outline-secondary active">Unités d'enseignement</a>
		  	</c:if>
		  	<c:if test="${!list.equals('listUE')}">
		  		<a href="/PimpMySchool/formation/ue" class="btn btn-outline-secondary">Unités d'enseignement</a>
		  	</c:if>
		</div>
	
		<h1>${title}</h1>
	
		<div class="row">
			<div class="col-md-4 col-sm-12 mb-2">
				<jsp:include page="${list}.jsp" />
			</div>
			<div class="col-md-8 col-sm-12 mb-2">
				<jsp:include page="${form}.jsp" />
			</div>
		</div>
	</div>

</body>
</html>