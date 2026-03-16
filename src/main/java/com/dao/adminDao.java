package com.dao;

import com.model.Admin;

public interface adminDao {

	boolean validate(Admin admin);

	boolean approveFaculty(int id);
	boolean rejectFaculty(int id);	
}
