package main.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// This class manages the initial login UI
public class LoginManager implements ActionListener {
	private String SIGN_IN = "SIGN_IN";

	public void showLoginScreen() {
		// Create and set up the window.
        JFrame frame = new JFrame("LoginManagerLoginView");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Box box = Box.createVerticalBox();
        JLabel usernameLabel = new JLabel("Username");
        box.add(usernameLabel);
        JTextField usernameField = new JTextField();
        box.add(usernameField);
        JLabel passwordLabel = new JLabel("Password");
        box.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField(10);
        box.add(passwordField);
        JButton signinButton = new JButton("Sign in");
        signinButton.setActionCommand(SIGN_IN);
        signinButton.addActionListener(this);
        box.add(signinButton);
        frame.getContentPane().add(box, BorderLayout.WEST);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (SIGN_IN.equals(e.getActionCommand())) {
			// TODO implement handling login
		}
	}
}
