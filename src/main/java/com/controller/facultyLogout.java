package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class facultyLogout extends HttpServlet {
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	       HttpSession session=request.getSession();
	       session.removeAttribute("username");
	       session.invalidate();
	       response.sendRedirect(request.getContextPath()+"/views/teacher_login.jsp");
	}


}
