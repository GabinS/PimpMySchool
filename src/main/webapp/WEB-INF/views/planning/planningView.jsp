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
  					<tr>
						<td>Janvier</td>
						<td>jeu</td>
						<td>18</td>
						<td>UML</td>
						<td>Alexandre</td>
					</tr>
  			<!-- 	<c:forEach items="${listePlannings}" var="planning">
					<tr>
						<td>${planning.id}</td>
						<td>${planning.jourSemaine}</td>
						<td>${planning.numeroJour}</td>
						<td>${planning.Module}</td>
						<td>${planning.formateur}</td>
					</tr>
				</c:forEach> -->
  				</tbody>
			</table>
		
	</div>

</body>
</html>
			
