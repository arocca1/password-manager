package main.data.storage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.account.User;

public class AccountReader {
	private String userAccountFileLocation = String.format(System.getProperty("user.dir"), "unimportant_things");
	private ObjectMapper mapper;

	public AccountReader() {
		mapper = new ObjectMapper();
	}

	// TODO move the credential reading into a generic class for this and CredentialReader
	private String decryptLine(String line) {
		return Encryptor.decrypt(line);
	}

	// TODO again, so I don't forget. move the credential reading into a generic class for this and CredentialReader
	public List<User> readUserAccounts() {
		BufferedReader br = null;
		List<User> users = new ArrayList<User>();
		try {
			br = new BufferedReader(new FileReader(userAccountFileLocation));
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				String decryptedLine = decryptLine(currentLine);
				users.add(mapper.readValue(decryptedLine, User.class));
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
		return users;
	}
}
