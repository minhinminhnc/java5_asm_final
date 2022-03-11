<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="col-10 offset-1">
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Sản phẩm</th>
      <th scope="col">Đơn giá</th>
      <th scope="col">Số lượng</th>
      <th scope="col">Thành tiền</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="item" items="${list }">
  	<tr>
      <th scope="row">${item.product.name }</th>
      <td>${item.price }</td>
      <td>${item.quantity }</td>
      <td>${item.price * item.quantity }</td>
    </tr>
  </c:forEach>
    
  </tbody>
</table>

	</div>

</body>
</html>