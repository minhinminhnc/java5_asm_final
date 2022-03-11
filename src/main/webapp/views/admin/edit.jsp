<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"></link>
</head>
<body>

	<div class="row col-10 offset-1 mt-5">
	<div class="col-5">
	
	<form:form action="/admin/product/update?id=${product.id }" method="post" modelAttribute="product">
  <div class="mb-3">
    <label class="form-label">Name</label>
    <form:input path="name" type="text" class="form-control" ></form:input>
    <form:errors path="name" element="span" cssClass="text-danger" />
  </div>
   <div class="mb-3">
    <label class="form-label">Price</label>
    <form:input path="price" type="text" class="form-control" ></form:input>
    <form:errors path="price" element="span" cssClass="text-danger" />
  </div>
  <div class="mb-3">
    <label class="form-label">Quantity</label>
    <form:input path="quantity" type="text" class="form-control" ></form:input>
    <form:errors path="quantity" element="span" cssClass="text-danger" />
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
	</div>
  
  <div class="col-5">
  
   <div class="mb-3">
    <label class="form-label">Image</label>
    <form:input path="image" type="text" class="form-control" ></form:input>
    <form:errors path="image" element="span" cssClass="text-danger" />
    <img src="${product.image }" style="width: 300px; height: 400px">
  </div></div>
	</div>
</form:form>


	
</body>
</html>