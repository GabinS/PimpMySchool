<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Page de connexion</title>
</head>
<body>
	<!-- A remettre avec authetification grâce à WebSecurityConfigurerAdapter (outil de gestion de connexion)
	   <form method="post" action="perform_login">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			-->
		<div>
			<label>Pseudo :</label> <input type="text" name="username" />
		</div>

		<div>
			<label>MDP :</label> <input type="password" name="password" />
		</div>

		<div>
			<button type="submit">Connexion</button>
		</div>

		<div>
			<a href="/register">S'inscrire</a>
		</div>
	<!-- </form>-->

</body>
</html>