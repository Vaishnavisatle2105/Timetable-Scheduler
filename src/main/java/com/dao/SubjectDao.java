package com.dao;

import java.util.List;

import com.model.Subject;

public interface SubjectDao {

	boolean addSubject(Subject s);
	List<Subject> getAllSubjects();
	Subject getSubjectById(int id);
	boolean updateSubject(Subject s);
	boolean deleteSubject(int id);
}
