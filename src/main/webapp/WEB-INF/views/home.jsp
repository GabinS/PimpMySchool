<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<jsp:include page="style.jsp" />
		<title>${title}</title>
	</head>
	<body>
		<jsp:include page="menu.jsp" />
		
		<div class="container">	
			<h1>${title}</h1>
	
			<div class="row">
				<div class="col-md-8 col-sm-12">
					<!-- Infos rapide de l'utilisateur -->
				</div>
				<div class="col-md-4 col-sm-12">
					<!-- Planning -->
				</div>
			</div>
			
		</div>
	</body>
</html>