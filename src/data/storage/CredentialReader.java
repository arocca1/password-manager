package data.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import data.Credential;
import data.Folder;

public class CredentialReader {
	private String credentialFileLocation;

	public CredentialReader(String username) {
		credentialFileLocation = String.format("%1$s%2$scred-%3$s", System.getProperty("user.dir"), File.separator, username);
	}

	private String decryptLine(String line) {
		return Encryptor.decrypt(line);
	}

	private List<Credential> parseCredentials(JSONArray credentialsJSON) {
		List<Credential> creds = new ArrayList<Credential>();
		// TODO implement the JSON parsing
		return creds;
	}

	public List<Folder> readCredentials() {
		BufferedReader br = null;
		List<Folder> folders = new ArrayList<Folder>();
		try {
			br = new BufferedReader(new FileReader(credentialFileLocation));
			String currentLine;
			JSONParser parser = new JSONParser();
			while ((currentLine = br.readLine()) != null) {
				try {
					String decryptedLine = decryptLine(currentLine);
					Object obj = parser.parse(decryptedLine);
					JSONObject jsonObject = (JSONObject)obj;
					String name = (String)jsonObject.get("name");
					List<Credential> credentials = parseCredentials((JSONArray)jsonObject.get("credentials"));
					folders.add(new Folder(name, credentials));
				} catch (ParseException pe) {
					// TODO log this somewhere
				}
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
		return folders;
	}

	private String encryptLine(String line) {
		return Encryptor.encrypt(line);
	}

	public void saveCredentials(List<Folder> credentialFolders) {
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
