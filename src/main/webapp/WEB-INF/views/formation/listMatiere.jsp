<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<a href="/PimpMySchool/formation/matiere/add" class="btn btn-lg btn-primary btn-block my-4">Ajouter une matière</a>

<div class="list-group">
	<c:forEach items="${listmatiere}" var="m">
	    <c:if test="${matiere.id == m.id}">
		    <a href="/PimpMySchool/formation/matiere/edit/${m.id}"
		    class="list-group-item list-group-item-action list-group-item-dark active">
				${m.titre}
			</a>
		</c:if>
		<c:if test="${matiere.id != m.id}">
		    <a href="/PimpMySchool/formation/matiere/edit/${m.id}"
		    class="list-group-item list-group-item-action list-group-item-dark">
				${m.titre}
			</a>
		</c:if>
	</c:forEach>
</div>