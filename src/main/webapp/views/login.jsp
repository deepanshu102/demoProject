<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<head>
<title>Login|Indigo</title>
</head>
<%@ include file="header.jsp"%>
<div class="container">
<br>
	<h4>${error}</h4>
	<form:form action="/signIn" method="post" modelAttribute="customer">
		<div class="form-group">
			<label for="email">Email address:</label> <input type="email"
				class="form-control" name="email" id="email" tabindex=1 required>
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label> <input type="password"
			tabindex=2	class="form-control" name="password"  id="pwd" required>
		</div>
		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>

<%@ include file="footer.jsp"%>


