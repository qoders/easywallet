package org.qoders.easywallet.service;

import java.util.List;

import org.qoders.easywallet.domain.Companion;
import org.qoders.easywallet.domain.Receipt;
import org.qoders.easywallet.domain.User;

/**
 * 
 * @author Nhu Trinh
 *
 */
public interface CompanionService {
	
	public List<Companion> findAllByReceipt(Receipt receipt);
	public List<Companion> findActiveByReceipt(Receipt receipt);
	
	public List<Companion> findAllByOwner(User owner);
	public List<Companion> findActiveByOwner(User owner);
	public List<Companion> findAllByUser(User user);
	public List<Companion> findActiveByUser(User user);
	
	public Double getTotalUserHave(User user);
	public Double getTotalUserOwn(User user);
	public Double getTotalAmount(List<Companion> companions);
}
