<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.keduit.dto.EmployeesVO"%>
<%@page import="com.keduit.dao.EmployeesDAO"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 추가</title>
<Link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/employees.js"></script>
</head>
<body>
	<div id="wrap" align="center"> <%--EmployeesServlet viewPage.jsp --%>
		<h1>사원 추가</h1> 
		<form id="frm" method="post" enctype="multipart/form-data" action="EmployeesServlet">
	<%--		<input type="hidden" name="command" value="employees_write"> --%>
			<table>
				<tr>
					<th>사원번호</th>
					<td><input type="text" name="id" id="id" required> * 필수(오늘날짜+입사순서 ex 2022122801)</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass" id="pass" required> * 필수 (직원정보 수정, 삭제 시 필요합니다.)</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<th>직급</th>
					<td><input type="text" name="lev" required> * 필수(A:일반사원, B:팀장, D:임원, E:대표)</td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input type="text" name="gender" required> * 필수(0:남자 1:여자)</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="tel" name="phone"></td>
				</tr>
				<tr>
					<th>입사일</th>
					<td><input type="date" name="enter"></td>
				</tr>
				<tr>
					<th>이 미 지</th>
					<td>
   						<input type="file" name="pictureurl"><br/><br/>
					</td>
				</tr>
			</table>
			<br><br>
			<input type="submit" value="등록">
			<input type="reset" value="다시작성">
			<input type="button" value="목록" onclick="location.href='EmployeesServlet?command=employees_list'">
		</form>
	</div>
</body>
</html>