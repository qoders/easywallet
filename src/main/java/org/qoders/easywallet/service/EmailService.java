package org.qoders.easywallet.service;

import java.util.Map;

/**
 * 
 * @author Nhu Trinh
 *
 */
public interface EmailService {
	public boolean sendMail(String toAddress, String subject, String message);
	boolean sendHtmlMail(String toAddress, String subject, String text,
			String template, Map<String, Object> context);
}
