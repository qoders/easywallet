package org.qoders.easywallet.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.qoders.easywallet.service.LanguageService;
import org.springframework.stereotype.Service;

/**
 * Service for Language, i18n
 * @author Nhu Trinh
 *
 */
@Service
public class LanguageServiceImpl implements LanguageService  {
	
	/**
	 * Generate map<language_key, Language_name> object. Temporary in memory implementation.
	 * TODO: Get settings from context
	 */
	public Map<String, String> getAvailableLanguage() {
		Map<String, String> languages = new HashMap<String, String>();
		languages.put("en", "English");
		languages.put("vi", "Tiếng Việt");
		languages.put("ne", "Nepali");
		return languages;
	}
	
}
