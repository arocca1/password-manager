package main.data.storage;

import java.io.File;
import java.util.List;

import main.data.CredentialStore;
import main.data.Folder;

public class CredentialReader extends SafeFileReader<Folder> {
    public CredentialReader(String username) {
        super(Folder.class);
        fileLocation = String.format("%1$s%2$scred-%3$s", System.getProperty("user.dir"), File.separator, Encryptor.encrypt(username));
    }

	public CredentialStore readCredentials() {
	    List<Folder> folders = readObjectsFromFile();
	    return new CredentialStore(folders);
	}

	public void saveCredentials(CredentialStore credStore) {
		saveObjectsToFile(credStore.getFolders());
	}
}
