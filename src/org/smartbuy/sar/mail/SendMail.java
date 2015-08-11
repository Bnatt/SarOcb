package org.smartbuy.sar.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class SendMail{
	
	@Autowired
	private MailSender mailSender;
	
	private int storeNumber;
	
	@Value("${mail.subject}")
	private String subject;
	
	@Value("${mail.message}")
	private String messageBody;
	
	/**
	 * Have hardcoded the storeNumber in the @Value value field to 2894(store number)
	 */
	
	@Value("${2894}")
	private String to;
	
	@Value("${mail.from}")
	private String from;	
	public void sendMail(int PoNumber, int storeNumber) {
		this.storeNumber = storeNumber;
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(from);
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(messageBody + Integer.toString(PoNumber));
		
		mailSender.send(simpleMailMessage);
		
	}
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}	
}