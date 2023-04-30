package model;

public class Registration {
	private String userId;
	private String pass;

	public Registration(String userId, String pass) {
		this.userId = userId;
		this.pass = pass;
	}
	public String getUserId() {
		return userId;
	}
	public String getPass() {
		return pass;
	}

}
