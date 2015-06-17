package org.qoders.easywallet.service;

import java.util.List;

import org.qoders.easywallet.domain.Group;
import org.qoders.easywallet.domain.User;

/**
 * 
 * @author Bisoo
 *
 */
public interface GroupService {
	
	public void createGroup(Group group);
	public List<Group> findGroupByUser(User user);
	public void removeGroup(Group group);
	
}
