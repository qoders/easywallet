package org.qoders.easywallet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author Nhu Trinh
 *
 */
@Entity
public class Authority implements GrantedAuthority {
	private static final long serialVersionUID = 3595279593190531241L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="user_id")
	private Long userId;
	
	@Column(nullable=false)
	private String authority;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
