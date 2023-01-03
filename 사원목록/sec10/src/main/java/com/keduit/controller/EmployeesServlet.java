package com.keduit.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.controller.action.Action;
import com.keduit.controller.action.EmployeesListAction;
import com.keduit.dao.EmployeesDAO;
import com.keduit.dto.EmployeesVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/EmployeesServlet")
public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	String command = request.getParameter("command");
	
	if(command == null) {
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20* 1024*1024;
		
		MultipartRequest muti = new MultipartRequest(request,
													path,
													sizeLimit,
													encType,
													new DefaultFileRenamePolicy()
													); 

		String pictureurl = muti.getFilesystemName("pictureurl");

		
		
		EmployeesVO eVO = new EmployeesVO();
		eVO.setId(muti.getParameter("id"));
		eVO.setPass(muti.getParameter("pass"));
		eVO.setName(muti.getParameter("name"));
		eVO.setLev(muti.getParameter("lev"));
		eVO.setEnter(muti.getParameter("enter"));
		eVO.setGender(muti.getParameter("gender"));
		eVO.setPhone(muti.getParameter("phone"));
		eVO.setPictureurl(pictureurl);

		EmployeesDAO eDAO = EmployeesDAO.getInstance();
		eDAO.insertEmployees(eVO);
		
		new EmployeesListAction().excute(request, response);
		
		System.out.println(eVO);
		
		command = "employees_write";
		System.out.println("EmployeesServlet에서 요청받은거 확인 : " + command);

	
	}else {
		
	System.out.println("EmployeesServlet에서 요청받은거 확인 : " + command);
	ActionFactory af = ActionFactory.getInstance();
	Action action = af.getAction(command);
	
	System.out.println("서블릿에서 아이디값 들어가냐 : "+ request.getParameter("id"));
	if(action != null) {
		action.excute(request, response);
	}
	
	}}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
