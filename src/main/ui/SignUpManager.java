package main.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.springframework.security.crypto.bcrypt.BCrypt;

import main.account.User;
import main.data.CredentialStore;
import main.data.Folder;
import main.data.storage.AccountReader;

public class SignUpManager {
    private List<User> users;

    public SignUpManager(List<User> u) {
        users = u;
    }

	public void showSignupScreen() {
        // Create and set up the window.
        final JFrame frame = new JFrame("LoginManagerLoginView");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPnl = new JPanel(new GridLayout(0, 2));
        JLabel firstNameLabel = new JLabel("First name");
        topPnl.add(firstNameLabel);
        final JTextField firstNameField = new JTextField();
        topPnl.add(firstNameField);
        JLabel lastNameLabel = new JLabel("Last name");
        topPnl.add(lastNameLabel);
        final JTextField lastNameField = new JTextField();
        topPnl.add(lastNameField);
        JLabel emailLabel = new JLabel("Email");
        topPnl.add(emailLabel);
        final JTextField emailField = new JTextField();
        topPnl.add(emailField);
        JLabel usernameLabel = new JLabel("Username");
        topPnl.add(usernameLabel);
        final JTextField usernameField = new JTextField();
        topPnl.add(usernameField);
        JLabel passwordLabel = new JLabel("Password");
        topPnl.add(passwordLabel);
        final JPasswordField passwordField = new JPasswordField(10);
        topPnl.add(passwordField);

        JPanel btnPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                LoginManager lm = new LoginManager(users);
                lm.showLoginScreen();
                frame.dispose();
            }
        });
        btnPnl.add(cancelButton);
        JButton signUpButton = new JButton("Create");
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String enteredFirstName = firstNameField.getText();
                String enteredLastName = lastNameField.getText();
                String enteredEmail = emailField.getText();
                String enteredUsername = usernameField.getText();
                String enteredPassword = new String(passwordField.getPassword());
                User u = new User(enteredFirstName, enteredLastName, enteredEmail, enteredUsername, BCrypt.hashpw(enteredPassword, BCrypt.gensalt()));
                users.add(u);
                // store account in credential file
                AccountReader ar = new AccountReader();
                ar.saveObjectsToFile(users);
                // since it's a new user, instantiate a new reader
                CredentialStore store = new CredentialStore(new ArrayList<Folder>());
                // go to password manager view
                PasswordManager pm = new PasswordManager();
                pm.showFoldersView(u, store);
                frame.dispose();
            }
        });
        btnPnl.add(signUpButton);
        btnPnl.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPnl, BorderLayout.NORTH);
        mainPanel.add(btnPnl, BorderLayout.SOUTH);
        frame.add(mainPanel);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
