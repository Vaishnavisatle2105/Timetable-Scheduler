package com.model;

public class Department {
    private int dept_id;
    private String dept_name;
    private String HOD_name;

    public Department() {}


	public Department(int dept_id, String dept_name, String HOD_name) {
		
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.HOD_name = HOD_name;
	}


	public Department(String dept_name, String HOD_name) {
        this.dept_name = dept_name;
        this.HOD_name = HOD_name;
    }

    public int getDept_id() { return dept_id; }
    public void setDept_id(int dept_id) { this.dept_id = dept_id; }

    public String getDept_name() { return dept_name; }
    public void setDept_name(String dept_name) { this.dept_name = dept_name; }

    public String getHOD_name() { return HOD_name; }
    public void setHOD_name(String HOD_name) { this.HOD_name = HOD_name; }
}
