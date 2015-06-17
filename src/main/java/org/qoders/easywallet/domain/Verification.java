package org.qoders.easywallet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity(name="Verification")
@Table(name="verification")
public class Verification {
	@NotEmpty
	@Id
	private String email;
	@NotEmpty
	@Column(name="code")
	private String verificationCode;
	
	public Verification()
	{
		
	}
	public Verification(String email, String verificationCode) {
		super();
		this.email = email;
		this.verificationCode = verificationCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	
	
	
	

}
