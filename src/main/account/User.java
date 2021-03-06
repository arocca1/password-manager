package main.account;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String hashedPassword;

	// ONLY FOR SERIALIZABILITY
	public User() {
	}

	public User(String f, String l, String e, String u, String p) {
		firstName = f;
		lastName = f;
		email = e;
		username = u;
		hashedPassword = p;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
}
