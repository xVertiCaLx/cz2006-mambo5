package mambo5.Controller;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailController {

	private final String MAMBOJUMBO = "mambo.jumbo.5", HOST = "@gmail.com",
			VALIDATE = "dq2sqzvf", SMTP_SERVER = "smtp.gmail.com",
			PORT = "587";
	private Properties properties;
	
	private String MESSAGE_BALANCE_ALERT_SUBJECT = "CaMS: Low Card Balance Alert";

	public EmailController() {
		properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", SMTP_SERVER);
		properties.put("mail.smtp.port", PORT);
	}

	public boolean sendBalanceAlertEmail(String user, double amount) {
		boolean validate=false;
		Session session = Session.getInstance(properties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(MAMBOJUMBO+HOST, VALIDATE);
					}
				});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(MAMBOJUMBO+HOST));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(user));
			message.setSubject(MESSAGE_BALANCE_ALERT_SUBJECT);
			message.setText("Warning: \n Your card balance is low. You have $" + amount + "in your card. Kindly proceed to the nearest top up kiosk to top up and refresh your card balance.");

			Transport.send(message);
			validate = true;
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		return validate;
	}
}