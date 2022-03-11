<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="row text-center col-8 offset-2">
		<c:forEach var="item" items="${page.content }">
		<div class="card" style="width: 18rem;">
		<a href="/product/${item.id }">
		<img src="${item.image }" class="card-img-top" alt="...">
		</a>
			<div class="card-body">
				<h5 class="card-title">${item.name }</h5>
				<p class="card-text">${item.price }</p>
				<a href="/cart/add?id=${item.id }" class="btn btn-primary">Thêm Vào Giỏ</a>
			</div>
		</div>
	</c:forEach>
	</div>
	

	<nav aria-label="Page navigation example">
		<ul class="pagination col-3 offset-4 mt-5">
			<c:forEach end="${page.totalPages }" begin="1" var="i">
				<li class="page-item ${i - 1 == page.number ? 'active' : '' }"><a
					class="page-link" href="/products?page=${i }">${i }</a></li>
			</c:forEach>
		</ul>
	</nav>

</body>
</html>