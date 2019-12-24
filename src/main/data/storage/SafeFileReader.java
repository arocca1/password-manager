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

public abstract class SafeFileReader<T> {
	protected String fileLocation;
	private ObjectMapper mapper;
	private Class<T> className;

    public SafeFileReader(Class<T> cn) {
    	mapper = new ObjectMapper();
    	className = cn;
    }

	private String decryptLine(String line) {
		return Encryptor.decrypt(line);
	}

	public List<T> readObjectsFromFile() {
		BufferedReader br = null;
		List<T> objs = new ArrayList<T>();
		File f = new File(fileLocation);
		if (!f.exists()) {
			return objs;
		}
		try {
			br = new BufferedReader(new FileReader(f));
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				String decryptedLine = decryptLine(currentLine);
				objs.add(mapper.readValue(decryptedLine, className));
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
		return objs;
	}

	private String encryptLine(String line) {
		return Encryptor.encrypt(line);
	}

	public void saveObjectsToFile(List<T> objs) {
		BufferedWriter bw = null;
		File f = new File(fileLocation);
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			bw = new BufferedWriter(new FileWriter(f));
			for (T obj : objs) {
				String encryptedObj = encryptLine(mapper.writeValueAsString(obj));
				bw.write(encryptedObj);
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
