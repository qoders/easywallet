package org.qoders.easywallet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

/**
 * 
 * @author Nhu Trinh
 *
 */
@Entity(name="Companion")
@Table(name="companion")
public class Companion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Receipt receipt;

	@OneToOne(fetch=FetchType.EAGER)
	private User owner;
	
	@OneToOne(fetch=FetchType.EAGER)
	private User companion;
	
	@Column(length=255)
	private String description;
	
	@Column(nullable=false)
	@Min(value=0)
	private Double amount;
	
	@Column(nullable=false)
	private boolean settle = false;
	
	
	public Receipt getReceipt() {
		return receipt;
	}
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public User getCompanion() {
		return companion;
	}
	public void setCompanion(User companion) {
		this.companion = companion;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public boolean isSettle() {
		return settle;
	}
	public void setSettle(boolean settle) {
		this.settle = settle;
	}
	
}
