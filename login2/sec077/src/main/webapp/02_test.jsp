<%@page import="java.sql.Connection"%>
<%@page import="com.keduit.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAO의 DBCP연동 테스트</title>
</head>
<body>
<%
MemberDAO memDao = MemberDAO.getInstance();
Connection conn = memDao.getConnection();
out.print("DBCP연동 성공");
%>

</body>
</html>