<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업데이트</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
<h1>회원 정보 수정</h1>

<form action="memberUpdate.do" method="post" name="frm">
	<table>
			<tr>
				<td>이 름 </td>
				<td><input type="text" name="name" value="${mVO.name }" readonly></td>
			</tr>
			<tr>
				<td>아이디 </td>
				<td><input type="text" name="userid" value="${mVO.userid }" readonly></td>
			</tr>
			<tr>
				<td>암호 </td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td>암호확인 </td>
				<td><input type="password" name="pwd_check"></td>
			</tr>
			<tr>
				<td>이메일 </td>
				<td><input type="email" name="email"  value="${mVO.email }"></td>
			</tr>
			<tr>
				<td>전화번호 </td>
				<td><input type="tel" name="phone"  value="${mVO.phone }"></td>
			</tr>
			<tr>
				<td><label for="admin">등급 </label></td>
				<td><c:choose>
					<c:when test="${mVO.admin}=0">			
						<input type="radio" id="admin" name="admin" value="0" checked="checked">일반회원
						<input type="radio" id="admin" name="admin" value="1">관리자
					</c:when>
				<c:otherwise>
					<input type="radio" id="admin" name="admin" value="0" checked="checked">일반회원
					<input type="radio" id="admin" name="admin" value="1">관리자
				</c:otherwise>
				</c:choose>
				</td>
				
			</tr>
			<tr>
				<td align="right"><input type="submit" value="확인" onclick="return joinCheck()"></td>
				<td colspan="2" align="center">     
				<input type="reset" value="취소"></td>
			</tr>
			<tr>
				<td colspan="2">${message }</td>
			</tr>
	</table>
</form>

</body>
</html>