package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao{

	List<User> users = new ArrayList<User>();
	@Override
	public void add(User user) {
		users.add(user);
		//System.out.println(user.getFirstName() + " Hibernate ile eklendi.");
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ifEmailExists(String eMail) {
		for (User user : users) {
			if (user.getEmail() == eMail) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User getByEmail(String eMail) {
		for (User user : users) {
			if (user.getEmail() == eMail) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean checkPassword(String password) {
		for (User user : users) {
			if (user.getPassword() == password) {
				return true;
			}
		}

		return false;
	}

}
