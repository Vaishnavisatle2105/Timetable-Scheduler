package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAOFactory;
import com.dao.DepartmentDao;
import com.model.Department;


public class AddDepartmentServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dept_name = request.getParameter("dept_name");
        String HOD_name = request.getParameter("HOD_name");

        Department d = new Department(dept_name, HOD_name);
        DepartmentDao Dao=DAOFactory.getDepartmentDao();
        int status = Dao.addDepartment(d);

        if (status > 0) {
        	request.setAttribute("addD", "Department Added!!");
        	RequestDispatcher rd = request.getRequestDispatcher("/views/add_dept.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("addD", "Error inserting data");
            RequestDispatcher rd = request.getRequestDispatcher("/views/add_dept.jsp");
            rd.forward(request, response);
        }
    }
}
