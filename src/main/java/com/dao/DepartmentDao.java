package com.dao;

import java.util.List;

import com.model.Department;

public interface DepartmentDao {

	Department getDepartmentById(int id);
	int updateDepartment(Department d);
	int deleteDepartment(int id);
    int addDepartment(Department d);
    List<Department> getAllDepartments();
}
