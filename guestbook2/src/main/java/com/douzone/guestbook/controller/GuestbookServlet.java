package com.douzone.guestbook.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import com.douzone.guestbook.dao.GuestbookDao;
import com.douzone.guestbook.vo.GuestbookVo;



public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("a");
		if("add".equals(action)) {
			String name = request.getParameter("name");
	   		String password = request.getParameter("password");
	   		String contents = request.getParameter("message");
	   		
	   		Date today = new Date();
			
			SimpleDateFormat format1=new SimpleDateFormat("yyyyMMdd");
	   		String date = format1.format(today);
	   		
	   		GuestbookVo vo = new GuestbookVo();
	   		vo.setName(name);
	   		vo.setPassword(password);
	   		vo.setContents(contents);
	   		vo.setReg_date(date);
	   		
	   		new GuestbookDao().insert(vo);
	   		
	   		response.sendRedirect(request.getContextPath()+"/gl");
		}else if("delete".equals(action)) {
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			
			GuestbookVo vo =new GuestbookVo();
			
			long num = Long.parseLong(no);
			
			vo.setNo(num);
			vo.setPassword(password);
			
			boolean result =new GuestbookDao().delete(vo);
			
			response.sendRedirect(request.getContextPath()+"/gl");
			
		}else if("deleteForm".equals(action)) {
			RequestDispatcher rd= request.getRequestDispatcher("/views/deleteform.jsp");
			 rd.forward(request, response);
		}
		
		else {
			List<GuestbookVo> list = new GuestbookDao().findAll();

			 request.setAttribute("list", list);
			 
			 RequestDispatcher rd= request.getRequestDispatcher("/views/index.jsp");
			 rd.forward(request, response);
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	}

}
