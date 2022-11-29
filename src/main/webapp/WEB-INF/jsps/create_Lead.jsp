<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>
	<h2>Create | Lead</h2>
	<form action="savelead">
		<pre>
			First Name: <input type="text" name="firstName"/>
			Last Name:	<input type="text" name="lastName"/>
			Email: 		<input type="email" name="email"/>
			Mobile: 	<input type="number" name="mobile"/>
			Source:		<select name="source">
							<option value="">Select</option>
							<option value="newspaper">News Paper</option>
							<option value="tvnews">	  TV News	</option>
							<option value="seminar">  Seminar	</option>
							<option value="online">	  Online	</option>
						</select>
						<input type="submit" value="save"/>
		</pre>
	</form>
</body>
</html>