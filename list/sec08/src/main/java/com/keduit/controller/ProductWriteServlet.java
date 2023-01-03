package com.keduit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keduit.dao.ProductDAO;
import com.keduit.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productWrite.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
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
		String name = muti.getParameter("name");
		int price = Integer.parseInt(muti.getParameter("price"));
		String pictureurl = muti.getFilesystemName("pictureurl");
		String description = muti.getParameter("description");
		
		
		ProductVO pVO = new ProductVO();
		pVO.setName(name);
		pVO.setPrice(price);
		pVO.setPictureurl(pictureurl);
		pVO.setDescription(description);
		
		ProductDAO pDAO = ProductDAO.getInstance();
		pDAO.insertProduct(pVO);
		
		response.sendRedirect("productList.do");
	}

}
