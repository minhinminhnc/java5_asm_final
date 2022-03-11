<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"></link>
</head>
<body>
	<div class="col-4 offset-4">
	<h1 style="text-align: center; color: red">Create</h1>
	<form:form action="/admin/product/create" method="post" modelAttribute="product">
		<div class="mb-3 ">
			<label class="form-label">Name</label>
			<form:input path="name" type="text" class="form-control"></form:input>
			<form:errors path="name" element="span" cssClass="text-danger" />
		</div>
		<div class="mb-3 ">
			<label class="form-label">Image</label>
			<form:input path="image" type="text" class="form-control"></form:input>
			<form:errors path="image" element="span" cssClass="text-danger" />
		</div>
		<div class="mb-3 ">
			<label class="form-label">Price</label>
			<form:input path="price" type="text" class="form-control"></form:input>
			<form:errors path="price" element="span" cssClass="text-danger" />
		</div>
		<div class="mb-3 ">
			<label class="form-label">Quantity</label>
			<form:input path="quantity" type="text" class="form-control"></form:input>
			<form:errors path="quantity" element="span" cssClass="text-danger" />
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Category</label>
			<form:select class="form-select" path="category" items="${category }"
				itemValue="id" itemLabel="name"></form:select>
		</div>
		<button type="submit"  class="btn btn-primary">Create</button>
	</form:form>
	</div>
</body>
</html>