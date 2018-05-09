package com.main.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl {
	
	public SendMailServiceImpl()
	{}

	
	private static JavaMailSender javaMailSender;

    @Autowired
    public SendMailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
		
		public static void sendMail(String email,String message,String sub)
		{
			SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
			
			simpleMailMessage.setTo(email); 
			 simpleMailMessage.setSubject(message); 
			 simpleMailMessage.setText(sub);
			 System.out.println(simpleMailMessage);
			 javaMailSender.send(simpleMailMessage);
			 System.out.println("send");
			 
//			 logger.info(email);
//			 logger.info(message);
//			 logger.info(sub);
			 
			
			
			System.out.println("Email has been send to user" +message);
			 @SuppressWarnings("unused")
			boolean isSent = false;
			
			
		}
		

}
