<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		
	<c:if test="${limit > 0}">
		<table class="table table-bordered">
  				<thead>
    				<tr>
      					<th scope="col">Mois</th>
      					<th scope="col" colspan="2">Date</th>
      					<th scope="col">Module</th>
      					<th scope="col">Formateur</th>
    				</tr>
  				</thead>
  				<tbody>
  				
  			 	<c:forEach items="${plannings}" var="planning">
  			 	
  			 	<!-- Si la formation dure une journée -->
  			 	<c:if test="${planning.dateDebut == planning.dateFin}">
					<tr>
						<fmt:formatDate var="mois" pattern="MMMM" value="${ planning.dateDebut}" />
						<td>${mois}</td>
						<fmt:formatDate var="dateD" pattern="EEEE" value="${ planning.dateDebut}" />
						<td>${dateD}</td>
						<fmt:formatDate var="dateF" pattern="dd" value="${ planning.dateDebut }" />
						<td>${dateF}</td>
						<td style="background-color:${color}">${planning.matiere.getTitre()}</td>
						<td>${planning.matiere.getFormateur().getNom()}</td>
					</tr>
					</c:if>
					
					<!-- Si la formation dure plusieurs jours -->
					<c:if test="${planning.dateDebut != planning.dateFin}">
					<tr>
						<fmt:formatDate var="mois" pattern="MMMM" value="${ planning.dateDebut}" />
						<td>${mois}</td>
						<fmt:formatDate var="dateD" pattern="EEEE" value="${ planning.dateDebut}" />
						<td>${dateD}</td>
						<fmt:formatDate var="dateF" pattern="dd" value="${ planning.dateDebut }" />
						<td>${dateF}</td>
						<td style="background-color:${color}">${planning.matiere.getTitre()}</td>
						<td>${planning.matiere.getFormateur().getNom()}</td>
						<!--  date de début à la date de fin -->
					</tr>
					<tr>
						<fmt:formatDate var="mois" pattern="MMMM" value="${ planning.dateFin}" />
						<td>${mois}</td>
						<fmt:formatDate var="dateD" pattern="EEEE" value="${ planning.dateFin}" />
						<td>${dateD}</td>
						<fmt:formatDate var="dateF" pattern="dd" value="${ planning.dateFin }" />
						<td>${dateF}</td>
						<td style="background-color:${color}">${planning.matiere.getTitre()}</td>
						<td>${planning.matiere.getFormateur().getNom()}</td>
					</tr>
					</c:if>
				</c:forEach> 
  				</tbody>
			</table>
		</c:if>
			<c:if test="${limit == 0 }">
			<div class="alert alert-warning" role="alert">Aucun planning n'a été trouvé.</div>
			</c:if>
	</div>

</body>
</html>
			
