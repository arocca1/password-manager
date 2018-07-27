package main.ui;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import main.account.User;
import main.data.CredentialStore;
import main.data.Folder;

// This manages the actual password management view
// There will be additional views here
public class PasswordManager {
	private JFrame frame;

	public void showFoldersView(User user, CredentialStore store) {
		// Create and set up the window.
        frame = new JFrame("PasswordManagerFoldersView");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setJMenuBar(getMenuBar());
        setContent(frame.getContentPane(), store.getFolders());
        // Display the window.
        frame.pack();
        frame.setVisible(true);
	}

	private void setContent(Container contentPane, List<Folder> folders) {
		
	}
/*
	private JMenuBar getMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JTextField searchField = new JTextField("   Search...   ");
		searchField.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		    	search();
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		    	search();
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		    	search();
		    }

		    public List<Folder> search() {
		    	List<Folder> filteredFolders = new ArrayList<Folder>();
				// TODO implement search
		    	String searchText = searchField.getText();
				return filteredFolders;
			}
		});
		menuBar.add(searchField);
		JMenu aboutMenu = new JMenu("About");
		menuBar.add(aboutMenu);
		return menuBar;
	}
*/
}
