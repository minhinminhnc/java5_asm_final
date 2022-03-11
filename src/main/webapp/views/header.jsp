<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<header class="p-3 bg-dark text-white">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
          <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="/home" class="nav-link px-2 text-white">Trang Chủ</a></li>
          <li><a href="/products" class="nav-link px-2 text-white">Sản Phẩm</a></li>
          <c:if test="${sessionScope.account != null ? 'true' : 'false' }">
          	<li><a href="/cart" class="nav-link px-2 text-white">Giỏ Hàng</a></li>
          	<li><a href="/order" class="nav-link px-2 text-white">Đơn Hàng</a></li>
          </c:if>
          
        </ul>	

        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
          <input type="search" class="form-control form-control-dark" placeholder="Search..." aria-label="Search">
        </form>

        <div class="text-end">
        <c:if test="${sessionScope.account == null ? 'true' : 'false'}">
        	<a href="/login"><button type="button" class="btn btn-outline-light me-2">Đăng Nhập</button></a>
        	<a href="/registration"><button type="button" class="btn btn-warning">Đăng Ký</button></a>
        </c:if>
        <c:if test="${sessionScope.account != null ? 'true' : 'false'}">
        	<a href="/account/update"><button type="button" class="btn btn-warning">Cập Nhật</button></a>
        	<a href="/logout"><button type="button" class="btn btn-warning">Đăng Xuất</button></a>
        </c:if>
        </div>
      </div>
    </div>
  </header>