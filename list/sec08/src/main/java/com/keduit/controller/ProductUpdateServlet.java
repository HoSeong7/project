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

@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String code = request.getParameter("code");
		
		ProductDAO pDAO = ProductDAO.getInstance();
		ProductVO pVO = pDAO.selectProductByCode(code);
		
		request.setAttribute("product", pVO);
		RequestDispatcher dispatcher = request.getRequestDispatcher("product/productUpdate.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "UTF-8";
		int sizeLimit = 20*1024*1024;
		
		MultipartRequest multi = new MultipartRequest(request,
														path,
														sizeLimit,
														encType,
														new DefaultFileRenamePolicy());
		String code = multi.getParameter("code");
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String pictureurl = multi.getFilesystemName("pictureurl");
		String description = multi.getParameter("description");
		
		if(pictureurl == null) {
			pictureurl = multi.getParameter("nonmakeImg");
		}
		
		ProductVO pVO = new ProductVO();
		pVO.setCode(Integer.parseInt(code));
		pVO.setName(name);
		pVO.setPrice(price);
		pVO.setPictureurl(pictureurl);
		pVO.setDescription(description);
		
		ProductDAO pDAO = ProductDAO.getInstance();
		pDAO.updateProduct(pVO);
		
		response.sendRedirect("productList.do");
	}

}
