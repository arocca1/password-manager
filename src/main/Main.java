package main;

import java.util.List;

import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.account.User;
import main.data.storage.AccountReader;
import main.ui.LoginManager;

public class Main {
	private static List<User> readInUsers() {
		AccountReader reader = new AccountReader();
		return reader.readObjectsFromFile();
	}
	private static void showLoginScreen(List<User> users) {
		LoginManager loginManager = new LoginManager(users);
		loginManager.showLoginScreen();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Logger logger = LoggerFactory.getLogger(Main.class);
				List<User> users = readInUsers();
				logger.debug("Read users in");
				showLoginScreen(users);
				logger.debug("Login screen loaded");
			}
		});
	}
}