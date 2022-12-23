package com.keduit.controller;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.MemberDAO;
import com.keduit.dto.MemberVO;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/join.jsp");        // 가는 경로
		dispatcher.forward(request, response);    // 보내기
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		MemberVO mVO = new MemberVO();
		mVO.setName(name);
		mVO.setUserid(userid);
		mVO.setPwd(pwd);
		mVO.setEmail(email);
		mVO.setPhone(phone);
		mVO.setAdmin(Integer.parseInt(admin));
		
		MemberDAO mDAO = MemberDAO.getInstance();
		
		mDAO.insertMember(mVO);
		response.sendRedirect("login.do");
	
	}

}
