package main.data;

import java.util.ArrayList;
import java.util.List;

public class Folder {
	private String name;
	private List<Login> credentials;

	public Folder() {
		this.credentials = new ArrayList<Login>();
	}
	public Folder(String n, List<Login> c) {
		this.name = n;
		this.credentials = c;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Login> getCredentials() {
		return credentials;
	}

	public void addCredential(Login c) {
		credentials.add(c);
	}
}
