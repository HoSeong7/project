package com.keduit.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.MemberDAO;
import com.keduit.dto.MemberVO;

@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userid = request.getParameter("userid");
		MemberDAO mDAO = MemberDAO.getInstance();
		
		MemberVO mVO = mDAO.getMember(userid);
		request.setAttribute("mVO", mVO);
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberUpdate.jsp");
		dispatcher.forward(request, response);
		
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 폼의 내용 받기
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");

		MemberVO mVO = new MemberVO();
		mVO.setUserid(userid);
		mVO.setPwd(pwd);
		mVO.setEmail(email);
		mVO.setPhone(phone);
		mVO.setAdmin(Integer.parseInt(admin));
		
		MemberDAO mDAO = MemberDAO.getInstance();
		int result = mDAO.updateMember(mVO);
		if(result >0) {
			response.sendRedirect("login.do");
		}
}}
