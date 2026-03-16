package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Timetable;
import com.util.DBConnection;

public class TimetableDaoImpl implements TimetableDao {

	
	
	
	public boolean addTimetable(Timetable t) {
		  Connection con = DBConnection.getConnection();
                 boolean status=false;
                 int x=0;
        try {
        	
        	 PreparedStatement ps1 = con.prepareStatement("select faculty_id from subjects where sub_abbr= '"+t.getSub_abbr()+"' AND dept_id= "+t.getDept_id()+";");
        	 ResultSet rs1 = ps1.executeQuery();
             while (rs1.next()) {
            	 t.setFac_id(rs1.getInt("faculty_id"));
             }
        	
        	 String query = "INSERT INTO time_table(sem, day, time_slot, sub_abbr, fac_id, room_id, dept_id, year) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, t.getSem());
            ps.setString(2, t.getDay());
            ps.setString(3, t.getTime_slot());
            ps.setString(4, t.getSub_abbr());
            ps.setInt(5, t.getFac_id());
            ps.setInt(6, t.getRoom_id());
            ps.setInt(7, t.getDept_id());
            ps.setString(8, t.getYear());
            x= ps.executeUpdate();
            if(x!=0)
            	status=true;
            
            
        } catch (Exception e) { e.printStackTrace(); }
        return status;
    }

    public List<Timetable> getAllTimetables() {
    	  Connection con = DBConnection.getConnection();

        List<Timetable> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM time_table";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Timetable t = new Timetable();
                t.setTt_id(rs.getInt(1));
                t.setSem(rs.getString(2));
                t.setDay(rs.getString(3));
                t.setTime_slot(rs.getString(4));
                t.setSub_abbr(rs.getString(5));
                t.setFac_id(rs.getInt(6));
                t.setRoom_id(rs.getInt(7));
                t.setDept_id(rs.getInt(8));
                t.setYear(rs.getString(9));
                list.add(t);
            }
        } catch (Exception e) { }
        return list;
    }

    public Timetable getTimetableById(int id) {
    	  Connection con = DBConnection.getConnection();

        Timetable t = null;
        try {
            String q = "SELECT * FROM time_table WHERE tt_id=?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                t = new Timetable();
                t.setTt_id(rs.getInt(1));
                t.setSem(rs.getString(2));
                t.setDay(rs.getString(3));
                t.setTime_slot(rs.getString(4));
                t.setSub_abbr(rs.getString(5));
                t.setFac_id(rs.getInt(6));
                t.setRoom_id(rs.getInt(7));
                t.setDept_id(rs.getInt(8));
                t.setYear(rs.getString(9));
            }
        } catch (Exception e) { }
        return t;
    }

    public boolean updateTimetable(Timetable t) {
    	  Connection con = DBConnection.getConnection();
    	  boolean status=false;
          int x=0;
        try {
        	
        	 PreparedStatement ps1 = con.prepareStatement("select faculty_id from subjects where sub_abbr= '"+t.getSub_abbr()+"' AND dept_id="+t.getDept_id()+";");
        	 ResultSet rs1 = ps1.executeQuery();
             while (rs1.next()) {
            	 t.setFac_id(rs1.getInt("faculty_id"));
             }
        	
            String query = "UPDATE time_table SET sem=?, day=?, time_slot=?, sub_abbr=?, fac_id=?, room_id=?, dept_id=?, year=? WHERE tt_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, t.getSem());
            ps.setString(2, t.getDay());
            ps.setString(3, t.getTime_slot());
            ps.setString(4, t.getSub_abbr());
            ps.setInt(5, t.getFac_id());
            ps.setInt(6, t.getRoom_id());
            ps.setInt(7, t.getDept_id());
            ps.setString(8, t.getYear());
            ps.setInt(9, t.getTt_id());
            
            x= ps.executeUpdate() ;
           
            if(x!=0)
            	status=true;
        } catch (Exception e) { }
        return status;
    }

    public boolean deleteTimetable(int id) {
    	  Connection con = DBConnection.getConnection();
    	  boolean status=false;
          int x=0;
        try {
            String query = "DELETE FROM time_table WHERE tt_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            x= ps.executeUpdate() ;
            if(x!=0)
            	status=true;
        } catch (Exception e) { }
        return status;
    }
}
