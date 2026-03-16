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


public class DeleteDepartmentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("dept_id"));
        
        DepartmentDao Dao=DAOFactory.getDepartmentDao();
        int status = Dao.deleteDepartment(id);
        if (status > 0) {
        	request.setAttribute("editMsg", "Record Delete Succusefuly");
        	RequestDispatcher rd = request.getRequestDispatcher("/views/add_dept.jsp");
            rd.forward(request, response);
        } else {
        	 request.setAttribute("editMsg", "Deletion failed!!");
             RequestDispatcher rd = request.getRequestDispatcher("/views/add_dept.jsp");
             rd.forward(request, response);
        }
       
    }

}
