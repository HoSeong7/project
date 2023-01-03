<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업데이트하기</title>
<Link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
<div id="wrap">
<h1>상품 수정 - 관리자 페이지</h1>
	<form method="post" action="productUpdate.do" name="frm" encType="multipart/form-data">
		<input type="hidden" name="code" value="${product.code }">
		<input type="hidden" name="nonmakeImg" value="${product.pictureurl }">
			<table>
				<tr>
					<td>
						<c:choose>
							<c:when test="${empty product.pictureurl }">
								<img src="upload/nonmake.gif">
							</c:when>
							<c:otherwise>
								<img src="upload/${product.pictureurl }">
							</c:otherwise>
						</c:choose>
					</td>
					<td>
					<table>
						<tr>
							<th>상 품 명</th>
							<td><input type="text" name="name" size="80" value="${product.name }"></td>
						</tr>
						<tr>
							<th>가   격</th>
							<td><input type="text" name="price" value="${product.price }"> 원</td>
						</tr>
						<tr>
							<th>이 미 지</th>
							<td><input type="file" name="pictureurl"><br>
							(주의사항 : 이미지를 변경하고자 할때만 선택하세요.)</td>
						</tr>
							<tr>
							<th>설   명</th>
							<td><textarea cols="80" rows="10" name="description">${product.description }</textarea><br>
							</td>
						</tr>
					</table>					
					</td>
				</tr>
			</table>
		
		
		
		
		<br>
		<input type="submit" value="수정" onclick="return productCheck()">
		<input type="reset" value="다시작성">
		<input type="button" value="목록" onclick="location.href='productList.do'">
	</form>
</div>
</body>
</html>