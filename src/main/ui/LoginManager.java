package main.ui;

import javax.swing.JFrame;

// This class manages the initial login UI
public class LoginManager {
	public void showLoginScreen() {
		// Create and set up the window.
        JFrame frame = new JFrame("LoginManagerLoginView");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TODO implement login scren

        // Display the window.
        frame.pack();
        frame.setVisible(true);
	}
}
