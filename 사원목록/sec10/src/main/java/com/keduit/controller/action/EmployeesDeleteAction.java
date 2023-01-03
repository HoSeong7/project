package com.keduit.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.EmployeesDAO;

public class EmployeesDeleteAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id");
		
		System.out.println("EmployeesDeleteAction에서 받은 아이디 값 : " + request.getParameter("id"));
	
		EmployeesDAO eDAO = EmployeesDAO.getInstance();
		eDAO.deleteEmployees(id);
		new EmployeesListAction().excute(request, response);
	}

}
