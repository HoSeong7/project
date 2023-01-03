package com.keduit.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.EmployeesDAO;
import com.keduit.dto.EmployeesVO;

public class EmployeesUpdateAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmployeesVO eVO = new EmployeesVO();
		eVO.setId(request.getParameter("id"));
		eVO.setPass(request.getParameter("pass"));
		eVO.setName(request.getParameter("name"));
		eVO.setLev(request.getParameter("lev"));
		eVO.setGender(request.getParameter("gender"));
		eVO.setPhone(request.getParameter("phone"));
		eVO.setPictureurl(request.getParameter("pictureurl"));
		eVO.setEnter(request.getParameter("enter")); 
		EmployeesDAO eDAO = EmployeesDAO.getInstance();
		eDAO.updateEmployees(eVO);
		
		new EmployeesListAction().excute(request, response);
	}

}
