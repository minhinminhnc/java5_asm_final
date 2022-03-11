<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"></link>
</head>
<body>

	<div class="col-10 offset-1">
	<a href="/admin/product/create"><button type="button" class="btn btn-success mt-2 mb-2">Create</button></a>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Name</th>
				<th scope="col">Image</th>
				<th scope="col">Price</th>
				<th scope="col">Quantity</th>
				<th scope="col">Active</th>
				<th scope="col">#</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${listProducts }">
			<tr>
				<th scope="row">${item.id }</th>
				<td>${item.name }</td>
				<td>
					<img alt="" src="${item.image }" style="width: 80px; height: 130px]">
				</td>
				<td>${item.price }</td>
				<td>${item.quantity }</td>
				<td>${item.status == true ? 'Active' : 'Inactive' }</td>
				<td>
					<a href="/admin/product/edit?id=${item.id }"><button type="button" class="btn btn-primary">Edit</button></a>
					<c:if test="${item.status }">
					<a href="/admin/product/delete?id=${item.id }"><button type="button" class="btn btn-danger">Delete</button></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
	</div>
	
</body>
</html>