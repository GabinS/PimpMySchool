<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<a href="/PimpMySchool/formation/matiere/add" class="btn btn-md btn-primary btn-block">Ajouter une matière</a>

<ul class="list-group my-4">
	<c:forEach items="${listmatiere}" var="matiere">
	    <c:if test="${id == matiere.id}">
		    <a href="/PimpMySchool/formation/matiere/edit/${matiere.id}"><li class="list-group-item active">${matiere.titre}</li></a>
		</c:if>
		<c:if test="${id != matiere.id}">
		    <a href="/PimpMySchool/formation/matiere/edit/${matiere.id}"><li class="list-group-item ">${matiere.titre}</li></a>
		</c:if>
	</c:forEach>
</ul>