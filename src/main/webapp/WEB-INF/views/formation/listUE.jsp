<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<a href="/PimpMySchool/formation/ue/add" class="btn btn-lg btn-primary btn-block my-4">Ajouter une Unité d'enseignement</a>

<div class="list-group">
	<c:forEach items="${listUE}" var="ue">
	    <c:if test="${uniteEnseignement.id == ue.id}">
		    <a href="/PimpMySchool/formation/ue/edit/${ue.id}"
		    class="list-group-item list-group-item-action list-group-item-dark active">
				${ue.titre}
			</a>
		</c:if>
		<c:if test="${uniteEnseignement.id != ue.id}">
		    <a href="/PimpMySchool/formation/ue/edit/${ue.id}"
		    class="list-group-item list-group-item-action list-group-item-dark">
				${ue.titre}
			</a>
		</c:if>
	</c:forEach>
</div>