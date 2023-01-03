<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
<Link rel="stylesheet" type="text/css" href="css/shopping.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
	<div id="wrap">
		<h1>사원 목록</h1>
		<table class="list">
			<tr>
				<td colspan="6" style="border:white; text-align:right">
					<a href="EmployeesServlet?command=employees_write_form">사원 추가하기</a>
				</td>
			</tr>
			<tr>
				<th>직    급</th>
				<th>사원 번호</th>
				<th>이    름</th>
				<th>성    별</th>
				<th>입 사 일</th>
				<th>전화 번호</th>
			</tr>
			<c:forEach var="employees" items="${employeesList }">
			<tr>
				<td>
				<c:choose>
					<c:when test="${employees.lev.equals('E') }">
						대    표 <span class="material-symbols-outlined">thumb_up</span>
					</c:when>
					<c:when test="${employees.lev.equals('D') }">
						임    원 <span class="material-symbols-outlined">record_voice_over</span>
					</c:when>
					<c:when test="${employees.lev.equals('B') }">
						팀    장 <span class="material-symbols-outlined">settings_accessibility</span>
					</c:when>
					<c:otherwise>
						일반 사원 <span class="material-symbols-outlined">pool</span>
					</c:otherwise>
				</c:choose>
				</td>
				<td> <a href="EmployeesServlet?command=employees_view&id=${employees.id }">${employees.id }</a></td>
				<td>${employees.name }</td>
				<td>
				<c:choose>
					<c:when test="${employees.gender.equals('0') }">
								남    자 <span class="material-symbols-outlined">male</span>
					</c:when>
					<c:otherwise>
								여    자 <span class="material-symbols-outlined">female</span>
					</c:otherwise>
				</c:choose>
				</td>
				<td>${employees.enter}</td>
				<td><span class="material-symbols-outlined">smartphone</span> ${employees.phone }</td>
			</c:forEach>
		</table>
	</div>

</body>
</html>