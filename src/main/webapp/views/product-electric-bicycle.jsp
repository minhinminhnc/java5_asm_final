<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"></link>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="row text-center">
		<c:forEach var="item" items="${ listProducts}">
			<div class="card" style="width: 18rem;">
				<a href="${pageContext.request.contextPath}/products/${item.id}"><img
					src="${item.image }" class="card-img-top" alt="..."></a>
				<div class="card-body">
					<h5 class="card-title">${item.name }</h5>
					<p class="card-text">Giá : ${item.price }</p>
					<a href="#" class="btn btn-primary">Mua Hàng</a>
				</div>
			</div>
		</c:forEach>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>