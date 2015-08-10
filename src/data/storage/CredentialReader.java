package data.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import data.Folder;

public class CredentialReader {
	private String credentialFileLocation;
	private List<Folder> credentialFolders;

	public CredentialReader(String username) {
		credentialFileLocation = String.format("%1$s%2$scred-%3$s", System.getProperty("user.dir"), File.separator, username);
		credentialFolders = new ArrayList<Folder>();
	}

	private String decryptLine(String line) {
		// TODO implement decryption
		return null;
	}

	public void readCredentials() {
		credentialFolders.clear();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(credentialFileLocation));
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				// TODO figure out file format
			}
		} catch(IOException e) {
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
	}

	private String encryptLine(String line) {
		// TODO implement encryption
		return null;
	}

	public void saveCredentials() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(credentialFileLocation));
			for (Folder f : credentialFolders) {
				//TODO implement writing of file based on file format
			}
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
