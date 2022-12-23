package com.keduit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.keduit.dao.MemberDAO;
import com.keduit.dto.MemberVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		MemberDAO mDAO = MemberDAO.getInstance();
		int result = mDAO.userCheck(userid, pwd);
		
		if(result == 1) {
			MemberVO mVO = mDAO.getMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loginuser", mVO);
			request.setAttribute("message", "회원 가입 성공");
			url="main.jsp";
//			request.setAttribute("message", "로그인이 성공하였습니다.");
		}else if(result == 0){
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result == -1) {
			request.setAttribute("message", "없는 아이디입니다. 회원가입을 해주세요.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); // 전달
	}

}
