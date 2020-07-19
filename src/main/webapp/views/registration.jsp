<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<head>
<title>Register | Indigo</title>
</head>
<%@ include file="header.jsp"%>
<br>
<div class="container border">
<br>
	<form:form action="/signup" method="post" modelAttribute="customer">
		<div class="row">
			<div class="col-sm-4 form-group">
				<label for="firstname">First Name</label> <input type="text"
					placeholder="Enter First Name" name="firstName" tabindex=1 class="form-control"
					required />
			</div>
			<div class="col-sm-4 form-group">
				<label for="firstname">Last Name</label> <input type="text"
					placeholder="Enter Last Name" tabindex=2 name="lastName" class="form-control"
					required />
			</div>
		</div>
		<div class="form-group col-sm-8">
			<label for="email">Email address:</label> <input type="email"
				class="form-control" tabindex=3 id="email" name="email" required>
		</div>
		<div class="row">
			<div class="col-sm-4 form-group">
				<label for="pass">Password</label> <input type="password"
					placeholder="Enter your Password" name="password" tabindex=4 class="form-control"
					required />
			</div>
			<div class="col-sm-4 form-group">
				<label for="repass">Re-Passowrd</label> <input type="password"
					placeholder="ReType your Password" tabindex=5 class="form-control"
					required />
			</div>
		</div>
		<button type="submit" class="btn btn-success">Sign Up</button>
	</form:form>
	
</div>
<br>

<%@ include file="footer.jsp"%>


