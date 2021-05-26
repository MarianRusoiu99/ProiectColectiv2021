package email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	 public static void sendMail(String recepient,String text) throws Exception {
		 System.out.println("Se trimite mesajul");
		 Properties props= new Properties();
		 props.put("mail.smtp.auth", "true");
	     props.put("mail.smtp.starttls.enable", "true");
	     props.put("mail.smtp.host", "smtp.gmail.com");
	     props.put("mail.smtp.port", "587");
	     props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	     
	     String myAccountEmail="ghemes.silvana@gmail.com";
	     String e_password="interogatoriu00";
	     
	     Session session = Session.getInstance(props, new Authenticator() {
	    	 protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, e_password);
	    		 
	    	 }
	     });
	     
	     Message msg = prepareMessage(session, myAccountEmail,recepient,text);
		 Transport.send(msg);
		 System.out.println("Trimis cu succes");
	 }

	private static Message prepareMessage(Session session, String myAccountEmail, String recepient,String text) {
		
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(myAccountEmail));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			msg.setSubject("Cont Task Dispatcher");
			msg.setText(text);
			return msg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
