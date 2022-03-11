<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<div class="col-6 offset-4 mt-5">
	
	<form:form action="/login" modelAttribute="account" method="post">
		<div class="mb-3 col-4">
			<label class="form-label">User name</label>
			<form:input path="username" type="text" class="form-control"></form:input>
		</div>
		<div class="mb-3 col-4">
			<label class="form-label">Password</label>
			<form:input path="password" type="password" class="form-control"></form:input>
		</div>
		<div class="mb-3 form-check">
			<input type="checkbox" class="form-check-input"> <label
				class="form-check-label">Remember</label>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
	
	</div>
</body>
</html>