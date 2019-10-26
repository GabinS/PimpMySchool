<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<a href="/PimpMySchool/planning/vue" class="btn btn-lg btn-info btn-block my-4">Visualiser le planning</a>
<a href="/PimpMySchool/planning/add" class="btn btn-lg btn-primary btn-block my-4">Ajouter un cours</a>


<div class="list-group">
	<c:forEach items="${listPlanning}" var="m">
	    <c:if test="${planning.id == p.id}">
		    <a href="/PimpMySchool/planning/edit/${p.id}"
		    class="list-group-item list-group-item-action list-group-item-dark active">
				${p.id}
			</a>
		</c:if>
		<c:if test="${planning.id != p.id}">
		    <a href="/PimpMySchool/planning/edit/${p.id}"
		    class="list-group-item list-group-item-action list-group-item-dark">
				${p.id}
			</a>
		</c:if>
	</c:forEach>
</div>