package com.keduit.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.BoardDAO;
import com.keduit.dto.BoardVO;

public class BoardWriteAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardVO bVO = new BoardVO();
		bVO.setName(request.getParameter("name"));
		bVO.setPass(request.getParameter("pass"));
		bVO.setEmail(request.getParameter("email"));
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));

		BoardDAO bDAO = BoardDAO.getInstance();
		bDAO.insertBoard(bVO);
		
		new BoardListAction().excute(request, response);
		
		
	}

}
