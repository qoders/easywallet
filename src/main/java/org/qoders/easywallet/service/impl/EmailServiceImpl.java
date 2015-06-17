package org.qoders.easywallet.service.impl;

import java.util.Date;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.qoders.easywallet.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class EmailServiceImpl implements EmailService {

	private String fromEmail;
	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;
	
	@Autowired
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	@Autowired
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
	

	@Override
	public boolean sendMail(String toAddress, String subject, String body) {
		// TODO Auto-generated method stub
		System.out.println(fromEmail);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromEmail);
		message.setTo(toAddress);
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
		return true;
	}

	@Override
	public boolean sendHtmlMail(final String toAddress, final String subject, final String text,
			final String template, final Map<String, Object> context) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
				message.setTo(toAddress);
				message.setFrom(fromEmail);
				message.setSubject(subject);
				message.setSentDate(new Date());

				String text = VelocityEngineUtils.mergeTemplateIntoString(
						velocityEngine,
						template,
						"UTF-8", context);
				message.setText(text, true);
			}
		};
		mailSender.send(preparator);
		return true;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

}
