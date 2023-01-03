<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<Link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
<%--http://localhost:8080/sec08/productList.do --%>
<div id="wrap">
	<h1>상품 리스트 - 관리자 페이지</h1>
	<div id="write">
	<a href="productWrite.do">상품 등록</a>
	</div>
	<table border="1" class="center">
		<tr>
			<th>번호</th>
			<th class="long">이름</th>
			<th>가격</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="product" items="${productList }">
			<tr>
				<td>${product.code }</td>
				<td class="long">${product.name }</td>
				<td>${product.price } 원</td>
				<td><a href="productUpdate.do?code=${product.code }">상품수정</a></td>
				<td><a href="productDelete.do?code=${product.code }">상품삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>