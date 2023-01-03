<%@page import="com.keduit.dto.EmployeesVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 상세보기</title>
<Link rel="stylesheet" type="text/css" href="css/shopping.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script type="text/javascript" src="script/employees.js"></script>
</head>
<body>
	<h1>직원 상세보기</h1>
	<div id="wrap" align="center" style="border=10px"> <%-- rowspan="3"  colspan="1" --%>
			<table>
				<tr>
					<td rowspan="3" class="img" width="10%">
						<c:choose>
							<c:when test="${empty employees.pictureurl }">
								<img src="upload/nonmake.gif">
							</c:when>
							<c:otherwise>
								<img src="upload/${employees.pictureurl }">
							</c:otherwise>
						</c:choose>
					</td>				
					<th>직    급</th>
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
					<th>사원번호</th>
					<td>${employees.id }</td>		
				</tr>
				<tr>
					<th>이    름</th>
					<td>${employees.name }</td>
					<th>성    별</th>
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
				</tr>
				<tr>
					<th>전화 번호</th>
					<td><span class="material-symbols-outlined">smartphone</span> ${employees.phone }</td>
					<th>입 사 일</th>
					<td>${employees.enter }</td>
				</tr>
			</table>
			<br><br>
			<input type="button" value="직원 수정" onclick="open_win('EmployeesServlet?command=employees_check_pass_form&id=${employees.id}','update')">
			<input type="button" value="직원 해고" onclick="open_win('EmployeesServlet?command=employees_check_pass_form&id=${employees.id}','delete')">
			<input type="button" value="직원 목록" onclick="location.href='EmployeesServlet?command=employees_list'">
			<input type="button" value="직원 추가" onclick="location.href='EmployeesServlet?command=employees_write_form'">

	</div>
</body>
</html>