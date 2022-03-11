<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	
	<div class="card" style="width: 18rem;">
		<img src="${product.image }" class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">${product.name }</h5>
				<p class="card-text">${product.price }</p>
			</div>
		</div>
	
</body>
</html>