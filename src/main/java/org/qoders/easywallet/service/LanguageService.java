package org.qoders.easywallet.service;

import java.util.Map;

/**
 * Language services interface, use for retrieve available language in system, i18n support
 * @author Nhu Trinh
 *
 */
public interface LanguageService {
	
	public Map<String, String> getAvailableLanguage();
	
}
