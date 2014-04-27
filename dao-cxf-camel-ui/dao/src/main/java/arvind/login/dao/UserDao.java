package arvind.login.dao;

import arvind.login.model.User;

public interface UserDao {
	User getUser(String name, String password);
}

