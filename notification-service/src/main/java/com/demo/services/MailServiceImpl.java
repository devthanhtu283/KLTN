package com.demo.services;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Override
	public boolean send(String from, String to, String subject, String content) {
		try {
			
			MimeMessage mimeMessage = sender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom(from);
			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(content, true);
			
			sender.send(mimeMessage);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
