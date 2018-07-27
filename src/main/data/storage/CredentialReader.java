package main.data.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.data.CredentialStore;
import main.data.Folder;

public class CredentialReader {
	private String credentialFileLocation;
	private ObjectMapper mapper;

	public CredentialReader(String username) {
		credentialFileLocation = String.format("%1$s%2$scred-%3$s", System.getProperty("user.dir"), File.separator, Encryptor.encrypt(username));
		mapper = new ObjectMapper();
	}

	private String decryptLine(String line) {
		return Encryptor.decrypt(line);
	}

	public CredentialStore readCredentials() {
		BufferedReader br = null;
		List<Folder> folders = new ArrayList<Folder>();
		try {
			br = new BufferedReader(new FileReader(credentialFileLocation));
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				String decryptedLine = decryptLine(currentLine);
				folders.add(mapper.readValue(decryptedLine, Folder.class));
			}
		} catch (IOException e) {
			// TODO : log this somewhere
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ex) {
					// TODO : log this somewhere
				}
			}
		}
		return new CredentialStore(folders);
	}

	private String encryptLine(String line) {
		return Encryptor.encrypt(line);
	}

	public void saveCredentials(CredentialStore credStore) {
		BufferedWriter bw = null;
		try {
			// TODO handle file creation
			bw = new BufferedWriter(new FileWriter(credentialFileLocation));
			for (Folder f : credStore.getFolders()) {
				String encryptedFolder = encryptLine(mapper.writeValueAsString(f));
				bw.write(encryptedFolder);
			}
			bw.flush();
		} catch (IOException e) {
			// TODO : log this somewhere
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException ex) {
					// TODO : log this somewhere
				}
			}
		}
	}
}
