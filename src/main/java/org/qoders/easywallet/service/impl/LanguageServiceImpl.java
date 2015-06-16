package org.qoders.easywallet.service.impl;

import java.util.Map;

import org.qoders.easywallet.service.LanguageService;
import org.springframework.stereotype.Service;

/**
 * Service for Language, i18n support
 * @author Nhu Trinh
 *
 */
public class LanguageServiceImpl implements LanguageService  {
	
	private Map<String, String> enabledLanguage;
	/**
	 * Generate map<language_key, Language_name> object for all available languages. 
	 */
	public Map<String, String> getAvailableLanguage() {
		return enabledLanguage;
	}
	
	public Map<String, String> getEnabledLanguage() {
		return enabledLanguage;
	}
	public void setEnabledLanguage(Map<String, String> enabledLanguage) {
		this.enabledLanguage = enabledLanguage;
	}
	
}
