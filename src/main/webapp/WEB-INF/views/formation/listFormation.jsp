<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<a href="/PimpMySchool/formation/add" class="btn btn-lg btn-primary btn-block my-4">Ajouter une formation</a>

<div class="list-group">
	<c:forEach items="${listFormation}" var="f">
	    <c:if test="${formation.id == f.id}">
		    <a href="/PimpMySchool/formation/edit/${f.id}"
		    class="list-group-item list-group-item-action list-group-item-dark active">
				${f.libelle}
			</a>
		</c:if>
		<c:if test="${formation.id != f.id}">
		    <a href="/PimpMySchool/formation/edit/${f.id}"
		    class="list-group-item list-group-item-action list-group-item-dark">
				${f.libelle}
			</a>
		</c:if>
	</c:forEach>
</div>