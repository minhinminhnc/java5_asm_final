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
	<form action="/cart/checkout" class="mt-5" method="post">
	<h3 style="text-align: center; color: red">Thông tin nhận hàng</h3>
		<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Số điện thoại</label>
  <input type="text" name="phone" class="form-control" id="exampleFormControlInput1">
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Địa chỉ nhận hàng</label>
  <textarea name="address" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
</div>
<input type="submit" class="btn btn-primary" value="Đặt hàng"></button>
	</form>
	<a href="/cart/delete"><button class="btn btn-danger mb-5 mt-5">Làm mới giỏ hàng</button></a>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Tên</th>
      <th scope="col">Giá</th>
      <th scope="col">Số Lượng</th>
      <th scope="col">Thành Tiền</th>
      <th scope="col">#</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="item" items="${map }">
  	<c:if test="${item.value > 0 ? true : false }">
  	<tr>
      <th scope="row">${item.key.id }</th>
      <td>${item.key.name }</td>
      <td><fmt:formatNumber pattern="#,###" value="${item.key.price }"></fmt:formatNumber></td>
      <td>${item.value }	<a href="/cart/add?id=${item.key.id }"><button class="btn btn-success">+</button></a>	
      
      <c:if test="${item.value > 0 ? 'true' : false}"><a href="/cart/remove?id=${item.key.id }"><button class="btn btn-danger">-</button></a></c:if>
      </td>
      <td><fmt:formatNumber pattern="#,###" value="${item.key.price * item.value}"></fmt:formatNumber></td>
      <td><c:if test="${item.value > 0 ? 'true' : false}"><a href="/cart/clear?id=${item.key.id }""><button class="btn btn-danger">Xoá</button></a></c:if></td>
    </tr>
    </c:if>
  </c:forEach>
    
  </tbody>
</table>
<div>
	<h3>Tổng tiền: <span style="margin-left: 700px"><fmt:formatNumber pattern="#,###" value="${total}"></fmt:formatNumber>VND</span></h3>
</div>
	</div>

</body>
</html>