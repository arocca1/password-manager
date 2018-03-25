import javax.swing.SwingUtilities;

import ui.LoginManager;
import ui.PasswordManager;

public class Main {
	private static void showPasswordManager() {
		PasswordManager pwManager = new PasswordManager();
		pwManager.showFoldersView();
	}

	private static void showLoginScreen() {
		LoginManager loginManager = new LoginManager();
		loginManager.showLoginScreen();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// showLoginScreen();
				showPasswordManager();
			}
		});
	}
}