package data;

import java.util.ArrayList;
import java.util.List;

public class CredentialStore {
	List<Folder> folders;

	public CredentialStore() {
		this.folders = new ArrayList<Folder>();
	}

	public CredentialStore(List<Folder> f) {
		this.folders = f;
	}

	public List<Folder> getFolders() {
		return folders;
	}

	public void addFolder(Folder f) {
		folders.add(f);
	}
}
