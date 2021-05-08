package core.concretes;

import business.concretes.UserManager;
import core.abstracts.LoginService;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;
import registerWithGoogle.RegisterWithGoogleManager;

public class GoogleLoginAdapter implements LoginService{
	
	UserManager userManager = new UserManager(new EmailValidationManager(), new HibernateUserDao(), new MailManager());
	User user = new User();
	
	public GoogleLoginAdapter() {	
		
		RegisterWithGoogleManager registerWithGoogle = new RegisterWithGoogleManager();
		user.setFirstName(registerWithGoogle.firstName);
		user.setLastName(registerWithGoogle.lastName);
		user.setEmail(registerWithGoogle.email);
		user.setPassword(registerWithGoogle.password);
	}
	
		@Override
	public void addWithService() {
		userManager.add(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + " google ile eklendi.");
	}

	@Override
	public void loginWithService() {
		userManager.login(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + " google ile giriþ yaptý.");
		
	}

}
