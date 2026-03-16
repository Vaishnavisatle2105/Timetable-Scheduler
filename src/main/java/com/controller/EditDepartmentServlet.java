package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAOFactory;
import com.dao.DepartmentDao;
import com.model.Department;


public class EditDepartmentServlet extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        int id = Integer.parseInt(request.getParameter("dept_id"));
	        String name = request.getParameter("dept_name");
	        String hod = request.getParameter("HOD_name");

	        Department d = new Department(id,name,hod);
	        
	        DepartmentDao Dao=DAOFactory.getDepartmentDao();
	        int status = Dao.updateDepartment(d);
	        if (status > 0) {
	        	request.setAttribute("editMsg", "update Record Succesfuly");
	        	RequestDispatcher rd = request.getRequestDispatcher("/views/add_dept.jsp");
	            rd.forward(request, response);
	        } else {
	        	 request.setAttribute("editmsg", "update failed!!");
	             RequestDispatcher rd = request.getRequestDispatcher("/views/add_dept.jsp");
	             rd.forward(request, response);
	        }
	    }

}
