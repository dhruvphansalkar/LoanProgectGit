package com.cg.lms.bean;

public class EndUsers {
	
	private String login_id;
	private String password;
	private String role;
	
	public String getLogin_id() 
	{
		return login_id;
	}
	public void setLogin_id(String login_id) 
	{
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getRole()
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public EndUsers()
	{
		
	}
	
	public EndUsers(String login_id, String password, String role) {
		super();
		this.login_id = login_id;
		this.password = password;
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "EndUsers [login_id=" + login_id + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	
	
	
}
