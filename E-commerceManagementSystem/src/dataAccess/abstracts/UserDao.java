package dataAccess.abstracts;

import java.util.List;

import entities.concretes.User;

public interface UserDao {
	void add(User user);
	void delete(User user);
	void update(User user);
	User get(int id);
	List<User> getAll();
	boolean ifEmailExists(String eMail);
	User getByEmail(String eMail);
	boolean checkPassword(String password);
}
