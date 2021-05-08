import business.abstracts.UserService;
import business.concretes.UserManager;
import core.abstracts.LoginService;
import core.concretes.EmailValidationManager;
import core.concretes.GoogleLoginAdapter;
import core.concretes.MailManager;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User(1, "Rüstem", "Karademir", "rustemkarademir@gmail.com", "123456");
		User user2 = new User(2, "Muhammed", "Karademir", "rustemkarademir@gmail.com", "123456");
		User user3 = new User(3, "Muhammed", "Karademir", "rustemkarademir@hotmail.com", "12345");
		
		
		UserService userManager = new UserManager(new EmailValidationManager(), new HibernateUserDao(), new MailManager());
		userManager.add(user1);
		System.out.println("***********");

		userManager.add(user2);
		System.out.println("***********");
		userManager.add(user3);
		
		System.out.println("***********");
		System.out.println("E-posta üzerinden doðrulama yapýldý.");
		System.out.println("***********");

		
		userManager.login(user1);
		userManager.login(user2);
		
		System.out.println("***********");
		
		LoginService googleLoginAdapter = new GoogleLoginAdapter();
		googleLoginAdapter.addWithService();

		System.out.println("***********");
		
		googleLoginAdapter.loginWithService();

	}

}
