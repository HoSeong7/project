package com.keduit.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.BoardDAO;
import com.keduit.dto.BoardVO;

public class BoardViewAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/board/boardView.jsp";
		String num = request.getParameter("num");
		
		BoardDAO bDAO = BoardDAO.getInstance();
		bDAO.updateReadCount(num); // 조회수 올려주기
		
		BoardVO bVO = bDAO.selectOneBoardByNum(num);
		request.setAttribute("board", bVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
