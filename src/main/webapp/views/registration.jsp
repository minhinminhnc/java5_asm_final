<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"></link>
</head>
<body>
	<div class="offset-4 mt-5">	
	<form:form action="/registration" method="post" modelAttribute="accountr" >
  <div class="mb-3 col-3">
    <label  class="form-label">User name</label>
    <form:input path="username" type="text" class="form-control"  ></form:input>
    <form:errors path="username" element="span" cssClass="text-danger" />
  </div>
  <div class="mb-3 col-3">
    <label  class="form-label">Password</label>
    <form:input path="password" type="password" class="form-control"  ></form:input>
    <form:errors path="password" element="span" cssClass="text-danger" />
  </div>
  <div class="mb-3 col-3">
    <label  class="form-label">Full name</label>
    <form:input path="fullname" type="text" class="form-control"  ></form:input>
    <form:errors path="fullname" element="span" cssClass="text-danger" />
  </div>
  <div class="mb-3 col-3">
    <label  class="form-label">Email</label>
    <form:input path="email" type="text" class="form-control"  ></form:input>
    <form:errors path="email" element="span" cssClass="text-danger" />
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
		
	</div>
</body>
</html>