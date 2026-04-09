package com.controller;

import com.dao.*;
import com.model.Admin;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;



public class adminLogin extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
        String password = request.getParameter("password");

        Admin admin = new Admin(email,password);
        adminDao dao = DAOFactory.getAdminDao();
        
        if (dao.validate(admin)) {
        	
            HttpSession session=request.getSession();
            session.setAttribute("email",email);
            request.setAttribute("email", email);
            String username=admin.getUsername();
            request.setAttribute("username",username);
            session.setAttribute("username",username);
            RequestDispatcher rd = request.getRequestDispatcher("/views/adminDashB.jsp");
            rd.forward(request, response);
            
        } else {
            request.setAttribute("error", "Invalid 	Email or Password");
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin_login.jsp");
            rd.forward(request, response);
        }
	}
	
	}
