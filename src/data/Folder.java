package data;

import java.util.List;

public class Folder {
	private String name;
	private List<Credential> credentials;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Credential> getCredentials() {
		return credentials;
	}

	public void addCredential(Credential c) {
		credentials.add(c);
	}
}
