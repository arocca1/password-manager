package data;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class Credential {
	private String username;
	@JsonUnwrapped
	private Password password;
	private String website;
	private Folder folder;
	private String notes;
	private List<SecurityQuestion> securityQuestions;

	// ONLY FOR JSON SERIALIZATION/DESERIALIZATION
	public Credential() { }

	public Credential(String u, String p, String site) {
		this.username = u;
		this.password = new Password(p);
		this.website = site;
		this.securityQuestions = new ArrayList<SecurityQuestion>();
	}

	public Credential(String u, String p, String site, Folder f, String n, List<SecurityQuestion> questions) {
		this.username = u;
		this.password = new Password(p);
		this.website = site;
		this.folder = f;
		this.notes = n;
		if (questions != null)
			this.securityQuestions = new ArrayList<SecurityQuestion>();
		else
			this.securityQuestions = questions;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String retrieveHiddenPassword() {
		return password.retrieveHiddenPassword();
	}
	
	public String retrieveRealPassword() {
		return password.retrieveRealPassword();
	}
	
	public void setPassword(String password) {
		this.password = new Password(password);
	}

	public Folder getFolder() {
		return folder;
	}
	
	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public List<SecurityQuestion> getSecurityQuestions() {
		return securityQuestions;
	}
	
	public void addSecurityQuestion(SecurityQuestion securityQuestion) {
		this.securityQuestions.add(securityQuestion);
	}
}
