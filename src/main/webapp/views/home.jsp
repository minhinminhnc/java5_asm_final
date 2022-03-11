<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"></link>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="${navbar }"></jsp:include>
	<c:if test="${jsp == null }"><img src="https://wallpaperaccess.com/full/333399.jpg" class="img-fluid" alt="..."></c:if>
	<jsp:include page="${jsp }"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>