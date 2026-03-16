package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAOFactory;
import com.dao.SubjectDao;


public class DeleteSubjectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("sub_id"));
        SubjectDao dao = DAOFactory.getSubjectDao();
        
        if(dao.deleteSubject(id)) {
            request.setAttribute("delmsg1", "Record Deleted!!");
        	RequestDispatcher rd = request.getRequestDispatcher("/views/add_subject.jsp");
            rd.forward(request, response);
        }else {
        	
        	request.setAttribute("delmsg1", "some error occur!!");
        	RequestDispatcher rd = request.getRequestDispatcher("/views/add_subject.jsp");
            rd.forward(request, response);
        }
    }


}
