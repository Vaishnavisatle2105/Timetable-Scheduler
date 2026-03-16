package com.model;

public class Faculty {

	private int fac_id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String dept;
    

	public Faculty() {
		
	}
	
	
	public Faculty(String username, String password, String email, String phone, String dept) {
	
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.dept = dept;
	}


	public Faculty(String email,String password) {
		
		this.password = password;
		this.email = email;
	}
	
	
	public Faculty(int fac_id, String username, String password, String email, String phone, String dept) {
	
		this.fac_id = fac_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.dept = dept;
	}
	public int getFac_id() {
		return fac_id;
	}
	public void setFac_id(int fac_id) {
		this.fac_id = fac_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
    
    
    
}
