package main.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.springframework.security.crypto.bcrypt.BCrypt;

import main.account.User;
import main.data.storage.CredentialReader;

// This class manages the initial login UI
public class LoginManager {
	private List<User> users;
	private Map<String, User> usernameToPassword;

	public LoginManager(List<User> users) {
		usernameToPassword = new HashMap<String, User>();
		for (User u : users) {
			usernameToPassword.put(u.getUsername(), u);
		}
		this.users = users;
	}

	public void showLoginScreen() {
		// Create and set up the window.
        final JFrame frame = new JFrame("LoginManagerLoginView");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set up the panel for errors and all of the inputs
        JPanel topPnl = new JPanel(new GridLayout(0, 2));

        // build up the bad login error message
        final JLabel badLoginLabel = new JLabel("Your username and/or password do not match");
        badLoginLabel.setBackground(Color.RED);
        badLoginLabel.setOpaque(true);
        badLoginLabel.setVisible(false);
        topPnl.add(badLoginLabel);
        final JLabel emptyLabel = new JLabel("");
        emptyLabel.setBackground(Color.RED);
        emptyLabel.setOpaque(true);
        emptyLabel.setVisible(false);
        topPnl.add(emptyLabel);

        // add in the labels and inputs for logging in, i.e. username and password
        JLabel usernameLabel = new JLabel("Username");
        topPnl.add(usernameLabel);
        final JTextField usernameField = new JTextField();
        topPnl.add(usernameField);
        JLabel passwordLabel = new JLabel("Password");
        topPnl.add(passwordLabel);
        final JPasswordField passwordField = new JPasswordField(10);
        topPnl.add(passwordField);

        // add signup and sign in buttons and corresponding events
        JPanel btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton signupButton = new JButton("Sign up");
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                SignUpManager sm = new SignUpManager(users);
                sm.showSignupScreen();
                frame.dispose();
            }
        });
        btnPnl.add(signupButton);
        JButton signinButton = new JButton("Sign in");
        signinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String enteredUsername = usernameField.getText();
                // TODO implement password retries
                if (usernameToPassword.containsKey(enteredUsername)) {
                    String enteredPassword = new String(passwordField.getPassword());
                    User user = usernameToPassword.get(enteredUsername);
                    String password = user.getHashedPassword();
                    if (BCrypt.checkpw(enteredPassword, password)) {
                        CredentialReader cr = new CredentialReader(enteredUsername);
                        PasswordManager pm = new PasswordManager();
                        pm.showFoldersView(user, cr.readCredentials());
                        frame.dispose();
                    }
                } else {
                    badLoginLabel.setVisible(true);
                    emptyLabel.setVisible(true);
                }
            }
        });
        btnPnl.add(signinButton);
        btnPnl.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // combine the panels to create the full window
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPnl, BorderLayout.NORTH);
        mainPanel.add(btnPnl, BorderLayout.SOUTH);
        frame.add(mainPanel);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
	}
}
