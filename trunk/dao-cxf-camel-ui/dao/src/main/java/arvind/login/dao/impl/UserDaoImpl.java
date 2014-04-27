package arvind.login.dao.impl;

import arvind.login.model.User;

public class UserDaoImpl {
	public User getUser(String name, String password) {
		return new User("Arvind", "arvind");
	}

}