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
      <th scope="col">Mã hoá đơn</th>
      <th scope="col">Tên người mua</th>
      <th scope="col">Ngày tạo</th>
      <th scope="col">Địa chỉ</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="item" items="${list }">
  	<tr>
      <th scope="row"><a href="/order/detail?id=${item.id }">${item.id }</a></th>
      <td>${item.account.fullname }</td>
      <td>${item.createDate }</td>
      <td>${item.address }</td>
    </tr>
  </c:forEach>
    
  </tbody>
</table>

	</div>

</body>
</html>