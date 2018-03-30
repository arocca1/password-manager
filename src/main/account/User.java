package main.account;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	
	public User(String f, String l, String e) {
		firstName = f;
		lastName = f;
		email = e;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
