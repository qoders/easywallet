package org.qoders.easywallet.service.impl;

import org.qoders.easywallet.domain.Verification;
import org.qoders.easywallet.repository.VerificationRepository;
import org.qoders.easywallet.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationServiceimpl implements VerificationService
 {
	@Autowired
	VerificationRepository verificationRepository;
	
	@Override
	public Verification verify(String email, String code) {
		// TODO Auto-generated method stub
		return verificationRepository.verify(email, code);
	}

	@Override
	public void save(Verification verification) {
		verificationRepository.save(verification);
		
	}

}
