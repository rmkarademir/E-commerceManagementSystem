package core.concretes;

import core.abstracts.MailService;

public class MailManager implements MailService{

	@Override
	public void sendMail(String eMail) {
		System.out.println("Do�rulama e-postas� mail adresinize g�nderildi: " + eMail + "\n" + "L�tfen e-posta adresinizi kontrol ediniz.");
		
	}

}
