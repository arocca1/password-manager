package main.data.storage;

import main.account.User;

public class AccountReader extends SafeFileReader<User> {
    public AccountReader() {
        super(User.class);
        fileLocation = System.getProperty("user.dir") + System.getProperty("file.separator") + "unimportant_things";
	}
}
