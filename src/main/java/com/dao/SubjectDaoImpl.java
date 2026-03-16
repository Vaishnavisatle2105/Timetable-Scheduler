package com.dao;

import java.sql.*;
import java.util.*;

import com.model.Subject;
import com.util.DBConnection;

public class SubjectDaoImpl implements SubjectDao {

	
	public boolean addSubject(Subject s) {
		Connection con = DBConnection.getConnection();
		 boolean status=false;
		 int x=0;
        try {
        	
            String query = "INSERT INTO subjects(sub_name, sub_code, sub_abbr, subject_type, sem, dept_id,faculty_id) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, s.getSub_name());
            ps.setString(2, s.getSub_code());
            
            if(s.getSubject_type().equals("Lab")) {
                  ps.setString(3, s.getSub_abbr()+" lab");
            }
            else {
            	 ps.setString(3, s.getSub_abbr());
            }
            ps.setString(4, s.getSubject_type());
            ps.setString(5, s.getSem());
            ps.setInt(6, s.getDept_id());
            ps.setInt(7, s.getFac_id());
            x= ps.executeUpdate();
            
            if(x!=0)
            	status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<Subject> getAllSubjects() {
        List<Subject> list = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try {
            String query = "SELECT * from subjects";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject s = new Subject();
                s.setSub_id(rs.getInt(1));
                s.setSub_name(rs.getString(2));
                s.setSub_code(rs.getString(3));
                s.setSub_abbr(rs.getString(4));
                s.setSubject_type(rs.getString(5));
                s.setSem(rs.getString(6));
                s.setDept_id(rs.getInt(7));
                s.setFac_id(rs.getInt(8));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Subject getSubjectById(int id) {
        Subject s = null;
        Connection con = DBConnection.getConnection();
        try {
            String query = "SELECT * FROM subjects WHERE sub_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = new Subject();
                s.setSub_id(rs.getInt(1));
                s.setSub_name(rs.getString(2));
                s.setSub_code(rs.getString(3));
                s.setSub_abbr(rs.getString(4));
                s.setSubject_type(rs.getString(5));
                s.setSem(rs.getString(6));
                s.setDept_id(rs.getInt(7));
                s.setFac_id(rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return s;
    }

    public boolean updateSubject(Subject s) {
    	Connection con = DBConnection.getConnection();
        try {
            String query = "UPDATE subjects SET sub_name=?, sub_code=?, sub_abbr=?, subject_type=?, sem=?, dept_id=?,faculty_id=? WHERE sub_id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, s.getSub_name());
            ps.setString(2, s.getSub_code());
          	 ps.setString(3, s.getSub_abbr());
            ps.setString(4, s.getSubject_type());
            ps.setString(5, s.getSem());
            ps.setInt(6, s.getDept_id());
            ps.setInt(7, s.getFac_id());
            ps.setInt(8, s.getSub_id());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean deleteSubject(int id) {
    	Connection con = DBConnection.getConnection();
        try {
            String query = "DELETE FROM subjects WHERE sub_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return false;
    }
	
	
}
