package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAOFactory;
import com.dao.TimetableDao;


public class DeleteTimetableServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("tt_id"));
        TimetableDao dao = DAOFactory.getTimetableDao();
        
        if(dao.deleteTimetable(id)) {
            request.setAttribute("delmsg2", "Record Deleted!!");
        	RequestDispatcher rd = request.getRequestDispatcher("/views/create_timetable.jsp");
            rd.forward(request, response);
        }else {
        	
        	request.setAttribute("delmsg2", "some error occur!!");
        	RequestDispatcher rd = request.getRequestDispatcher("/views/create_timetable.jsp");
            rd.forward(request, response);
        }
	}


}
