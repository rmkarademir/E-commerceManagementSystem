package business.concretes;

import java.util.List;

import business.abstracts.UserService;
import core.abstracts.MailService;
import core.concretes.EmailValidationManager;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{

	EmailValidationManager emailValidationManager;
	UserDao userDao;
	MailService mailService;
	
	public UserManager(EmailValidationManager emailValidationManager, UserDao userDao, MailService mailService) {
		super();
		this.emailValidationManager = emailValidationManager;
		this.userDao = userDao;
		this.mailService = mailService;
	}
	
	@Override
	public void add(User user) {
		if (!(user.getFirstName() == null) && !(user.getLastName() == null) && 
				!(user.getPassword() == null) && !(user.getEmail() == null) && 
				!(user.getFirstName().length()<2) && !(user.getLastName().length()<2) && 
				!(user.getPassword().length()<6)){
			if(emailValidationManager.isValid(user.getEmail()) && !userDao.ifEmailExists(user.getEmail())) {
				mailService.sendMail(user.getEmail());
				userDao.add(user);
			}else if(userDao.ifEmailExists(user.getEmail())) {
				System.out.println("Kullanýcý eklenemedi, sistemde kayýtlý email adresi mevcut: " + user.getEmail());
			}
			else if (!emailValidationManager.isValid(user.getEmail())){
				System.out.println("Kullanýcý eklenemedi, mail adresi hatalý " + user.getEmail());
			}	
		}
		else {
			System.out.println("Girilen bilgiler eksik. Lütfen bilgilerinizi kontrol ediniz." + 
					"\n" + "Ad ve Soyad en az iki karakter olacaktýr." + 
					"\n" + "Þifre en az 6 karakter olacaktýr.");
		}
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
	public void login(User user) {
		if(userDao.getByEmail(user.getEmail()) != null) {
			if(userDao.checkPassword(user.getPassword())) {
				System.out.println("Email ve parola doðrulandý. " + user.getFirstName() + " " 
						+ user.getLastName() + " sisteme giriþiniz gerçekleþiyor.");
			}
			else {
				System.out.println("Girilen þifre hatalý.");
			}
		}
		else {
			System.out.println("Girilen email sistemde mevcut deðil.");
		}
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
