package com.keduit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.MemberDAO;

@WebServlet("/idCheck.do")
public class idCheckSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String userid = request.getParameter("userid");
			MemberDAO mDAO = MemberDAO.getInstance();
			int result = mDAO.conformID(userid);
			
			request.setAttribute("userid", userid);
			request.setAttribute("result", result);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("member/idCheck.jsp");
			dispatcher.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
