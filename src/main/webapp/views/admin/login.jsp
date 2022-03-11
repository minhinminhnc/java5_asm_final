<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"></link>
</head>
<body>
	<div class="offset-4">
		<h1>LOGIN</h1>
	<form:form action="/admin/login" modelAttribute="account" method="post">
		<div class="mb-3 col-4">
			<label class="form-label">User name</label>
			<form:input path="username" type="text" class="form-control"></form:input>
			<form:errors path="username" element="span" cssClass="text-danger" />
		</div>
		<div class="mb-3 col-4">
			<label class="form-label">Password</label>
			<form:input path="password" type="password" class="form-control"></form:input>
			<form:errors path="password" element="span" cssClass="text-danger" />
		</div>
		<div class="mb-3 form-check">
			<input type="checkbox" class="form-check-input"> <label
				class="form-check-label">Remember</label>
		</div>
		<span>${message }</span><br>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
	</div>
</body>
</html>