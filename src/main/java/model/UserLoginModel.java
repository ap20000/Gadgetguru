package model;

public class UserLoginModel {
	private String user_Name;
	private String password;
	
	
	

	
	public UserLoginModel(String user_name, String password) {
		super();
		this.user_Name = user_name;
		this.password = password;
	}



	


	public String getUser_Name() {
		return user_Name;
	}



	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
	
}

