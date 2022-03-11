<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update</h1>
	<form:form action="/account/update?id=${account.id }" modelAttribute="account" method="post">
		<div class="mb-3 col-3">
			<label class="form-label">User name</label>
			<form:input path="username" type="text" class="form-control" readonly="true"></form:input>
		</div>
		<div class="mb-3 col-3">
			<label class="form-label">Password</label>
			<form:input path="password" type="password" class="form-control" readonly="true"></form:input>
		</div>
		<div class="mb-3 col-3">
			<label class="form-label">Full name</label>
			<form:input path="fullname" type="text" class="form-control"></form:input>
		</div>
		<div class="mb-3 col-3">
			<label class="form-label">Email</label>
			<form:input path="email" type="text" class="form-control"></form:input>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
</body>
</html>