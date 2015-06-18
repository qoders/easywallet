package org.qoders.easywallet.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * 
 * @author Nhu Trinh
 *
 */
@Entity(name="User")
@Table(name="user")
public class User implements UserDetails {
	
	private static final long serialVersionUID = -2920432491545182496L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="can not be empty")
	@Column(unique=true, length=50, name="username", nullable=false)
	@JsonIgnore
	private String username;
	
	@NotEmpty(message="can not be empty")
	@Column(length=255)
	@JsonIgnore
	private String password;
	
	@NotEmpty(message="can not be empty")
	@Column(unique=true, length=255, nullable=false)
	private String email;
	
	
	private String avatar;
	
	@NotEmpty(message="can not be empty")
	private String firstName;
	
	@NotEmpty(message="can not be empty")
	private String lastName;
	
	@NotEmpty(message="select gender")
	private String gender;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Authority> authorities;
	
    private boolean enabled;
    
    public User(){
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<GrantedAuthority> getAuthorities() {
		final Set <GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for(Authority auth: this.authorities){
			auths.add((GrantedAuthority)auth);
		}
		return auths;
	}

	public void setAuthorities(Set<GrantedAuthority> authorities) {
		final Set<Authority> auths = new HashSet<Authority>();
		for(GrantedAuthority ga: authorities){
			auths.add((Authority)ga);
		}
		this.authorities = auths;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getFirstName() {
		if(firstName!=null)
			return firstName;
		return "";
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		if(lastName!=null)
			return lastName;
		return "";
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String toString(){
		return this.getFirstName() + " " + this.getLastName();
	}

	
}
