package org.qoders.easywallet.service.impl;

import java.util.List;

import org.qoders.easywallet.domain.Group;
import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.repository.GroupRepository;
import org.qoders.easywallet.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
	
	@Autowired
	GroupRepository groupRepo;

	@Override
	public void createGroup(Group group) {
		groupRepo.save(group);
	}

	@Override
	public List<Group> findGroupByUser(User user) {
		return groupRepo.findByUser(user);
	}

	@Override
	public void removeGroup(Group group) {
		groupRepo.delete(group);		
	}

}
