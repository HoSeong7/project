<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원정보 수정</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/employees.js"></script>
</head>
<body>

<div id="wrap" align="center">
	<h1>직원정보 수정</h1>
	<form name="frm" method="post" enctype="multipart/form-data" action="EmployeesServlet2">
	<input type="hidden" name="nonmakeImg" value="${employees.pictureurl }">
		<table>
			<tr>
					<th>사원번호</th>
					<td><input type="text" name="id" id="id" value="${employees.id}" readonly> * 변경불가</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass" id="pass"> * 필수 (직원정보 수정, 삭제 시 필요합니다.)</td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${employees.name }"></td>
				</tr>
				<tr>
					<th>직급</th>
					<td><input type="text" name="lev" value="${employees.lev }"> * 필수(A:일반사원, B:팀장, D:임원, E:대표)</td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input type="text" name="gender" value="${employees.gender }"> * 필수(0:남자 1:여자)</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="tel" name="phone" value="${employees.phone }"></td>
				</tr>
				<tr>
					<th>입사일</th>
					<td><input type="date" name="enter" value="${employees.enter }"></td>
				</tr>
				<tr>
					<th>이 미 지</th>
					<td>
						
   						<input type="file" name="pictureurl"> * 변경하실 경우에만 수정해주세요. 기존 : ${employees.pictureurl}
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