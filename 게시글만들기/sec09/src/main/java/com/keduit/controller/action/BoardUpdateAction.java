package com.keduit.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.BoardDAO;
import com.keduit.dto.BoardVO;

public class BoardUpdateAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardVO bVO = new BoardVO();
		bVO.setNum(Integer.parseInt(request.getParameter("num")));
		bVO.setPass(request.getParameter("pass"));
		bVO.setName(request.getParameter("name"));
		bVO.setEmail(request.getParameter("email"));
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));
		
		BoardDAO bDAO = BoardDAO.getInstance();
		bDAO.updateBoard(bVO);
		
		new BoardListAction().excute(request, response);
	}

}
