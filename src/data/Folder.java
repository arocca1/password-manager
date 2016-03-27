package data;

import java.util.ArrayList;
import java.util.List;

public class Folder {
	private String name;
	private List<Credential> credentials;

	public Folder() {
		this.credentials = new ArrayList<Credential>();
	}
	public Folder(String n, List<Credential> c) {
		this.name = n;
		this.credentials = c;
	}

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
