package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAOFactory;
import com.dao.TimetableDao;
import com.model.Timetable;

public class EditTimetableServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Timetable t = new Timetable();

        t.setTt_id(Integer.parseInt(request.getParameter("tt_id")));
        t.setSem(request.getParameter("sem"));
        t.setDay(request.getParameter("day"));
        t.setTime_slot(request.getParameter("time_slot"));
        t.setSub_abbr(request.getParameter("sub_abbr"));
       // t.setFac_id(Integer.parseInt(request.getParameter("fac_id")));
        t.setRoom_id(Integer.parseInt(request.getParameter("room_id")));
        t.setDept_id(Integer.parseInt(request.getParameter("dept_id")));
        t.setYear(request.getParameter("year"));
        TimetableDao dao = DAOFactory.getTimetableDao();
      

        if (dao.updateTimetable(t)) {
        	request.setAttribute("editmsg3", "Record Updated!!");
        	RequestDispatcher rd = request.getRequestDispatcher("/views/create_timetable.jsp");
            rd.forward(request, response);
        } else {
        	request.setAttribute("editmsg3", "some error occur!!");
        	RequestDispatcher rd = request.getRequestDispatcher("/views/create_timetable.jsp");
            rd.forward(request, response);
        }
	}

}
