package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DAOFactory;
import com.dao.facultyDao;
import com.model.Faculty;


public class show_msgServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
      
        facultyDao dao = DAOFactory.getFacultyDao();
        String msg=dao.show_msg(email);
        if (msg!=null) {
        	
        	
        	if(msg.contains("APPROVED"))
        	     {request.setAttribute("error1",msg);}
        	else
        	{ request.setAttribute("error2",msg);}
            RequestDispatcher rd = request.getRequestDispatcher("/views/teacher_login.jsp");
            rd.forward(request, response);
            
        } else {
            request.setAttribute("error3", "Please wait.Your ragistration request is awaiting admin action !!");
            RequestDispatcher rd = request.getRequestDispatcher("/views/teacher_login.jsp");
            rd.forward(request, response);
        }
		
	}

}
