package core.concretes;

import core.abstracts.MailService;

public class MailManager implements MailService{

	@Override
	public void sendMail(String eMail) {
		System.out.println("Doðrulama e-postasý mail adresinize gönderildi: " + eMail + "\n" + "Lütfen e-posta adresinizi kontrol ediniz.");
		
	}

}
