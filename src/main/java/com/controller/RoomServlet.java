package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DAOFactory;
import com.dao.RoomDao;
import com.model.Room;


public class RoomServlet extends HttpServlet {
	RoomDao dao = DAOFactory.getRoomDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("add")) {
            Room r = new Room();
            r.setRoom_name(request.getParameter("room_name"));
            r.setRoom_num(Integer.parseInt(request.getParameter("room_num")));

            if (dao.addRoom(r)) {
            	request.setAttribute("addR", "Room Added!!");
            	RequestDispatcher rd = request.getRequestDispatcher("/views/add_room.jsp");
                rd.forward(request, response);
            } else {
            	request.setAttribute("addR", "some error occur!!");
            	RequestDispatcher rd = request.getRequestDispatcher("/views/add_room.jsp");
                rd.forward(request, response);
            }
        }

        if (action.equals("update")) {
            Room r = new Room();
            r.setRoom_id(Integer.parseInt(request.getParameter("room_id")));
            r.setRoom_name(request.getParameter("room_name"));
            r.setRoom_num(Integer.parseInt(request.getParameter("room_num")));

            if (dao.updateRoom(r)) {
            	request.setAttribute("editmsg1", "Record Updated!!");
            	RequestDispatcher rd = request.getRequestDispatcher("/views/add_room.jsp");
                rd.forward(request, response);
            } else {
            	request.setAttribute("editmsg1", "some error occur!!");
            	RequestDispatcher rd = request.getRequestDispatcher("/views/add_room.jsp");
                rd.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("room_id"));

        if (action.equals("delete")) {
            if(dao.deleteRoom(id)) {
            request.setAttribute("delmsg", "Record Deleted!!");
        	RequestDispatcher rd = request.getRequestDispatcher("/views/add_room.jsp");
            rd.forward(request, response);
        }else {
        	
        	request.setAttribute("delmsg", "some error occur!!");
        	RequestDispatcher rd = request.getRequestDispatcher("/views/add_room.jsp");
            rd.forward(request, response);
        }
      }
    }

}
