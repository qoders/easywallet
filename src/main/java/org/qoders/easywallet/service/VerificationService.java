package org.qoders.easywallet.service;

import org.qoders.easywallet.domain.Verification;



public interface VerificationService {
	
	public Verification verify(String email, String code);
	public void save(Verification verification);

}
