package com.dao;


public class DAOFactory {
	
static adminDao Adao;
static facultyDao Fdao;
	static DepartmentDao Ddao;
	static RoomDao Rdao;
	static SubjectDao Sdao;
	static TimetableDao Tdao;
	static {
		Adao = new adminDaoImpl();
		Fdao=new facultyDaoImpl();
		Ddao=new DepartmentDaoImpl();
		Rdao=new RoomDaoImpl();
		Sdao=new SubjectDaoImpl();
		Tdao=new TimetableDaoImpl();
	}
	
	public static adminDao getAdminDao() {
		//System.out.println("dao factory");
		return Adao;
	}

	public static facultyDao getFacultyDao() {
		
		return Fdao;
	}

	public static DepartmentDao getDepartmentDao() {
		
		return Ddao;
	}
	
public static RoomDao getRoomDao() {
		
		return Rdao;
	}

public static SubjectDao getSubjectDao() {
	
	return Sdao;
}

public static TimetableDao getTimetableDao() {
	
	return Tdao;
}
}
