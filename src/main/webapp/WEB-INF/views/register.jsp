<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cr�ation de compte</title>
</head>
<body>

	<form method="POST">
<!-- A remettre � la fin (utilisation du service de s�curit�)
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
 -->
		<div>
			<h1>Inscription � PimpMySchool</h1>
		</div>

		<div>
			<label>Pseudo :</label> <input type="text" name="username"
				required="required" />
		</div>

		<div>
			<label>MDP :</label> <input type="password" name="password"
				required="required" />
		</div>

		<div>
			<button type="submit">S'inscrire</button>
		</div>
	</form>

</body>
</html>