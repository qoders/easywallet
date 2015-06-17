package org.qoders.easywallet.service;

import java.util.List;

import org.qoders.easywallet.domain.Companion;
import org.qoders.easywallet.domain.User;

/**
 * 
 * @author Nhu Trinh
 *
 */
public interface CompanionService {
	
	public List<Companion> findAllByOwner(User owner);
	public List<Companion> findActiveByOwner(User owner);
	public List<Companion> findAllByUser(User user);
	public List<Companion> findActiveByUser(User user);
	
}
