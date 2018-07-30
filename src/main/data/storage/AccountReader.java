package main.data.storage;

import main.account.User;

public class AccountReader extends SafeFileReader<User> {
    public AccountReader() {
        super(User.class);
        fileLocation = String.format(System.getProperty("user.dir"), "unimportant_things");
	}
}
