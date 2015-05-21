package data;

import java.util.ArrayList;
import java.util.List;

public class Credential {
	private String username;
	private Password password;
	private String website;
	private Folder folder;
	private String notes;
	private List<SecurityQuestion> securityQuestions;
	
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

	public String getHiddenPassword() {
		return password.getHiddenPassword();
	}
	
	public String getRealPassword() {
		return password.getRealPassword();
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
