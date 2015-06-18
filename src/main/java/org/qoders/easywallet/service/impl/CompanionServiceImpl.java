package org.qoders.easywallet.service.impl;

import java.util.List;

import org.qoders.easywallet.domain.Companion;
import org.qoders.easywallet.domain.Receipt;
import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.repository.CompanionRepository;
import org.qoders.easywallet.service.CompanionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanionServiceImpl implements CompanionService {

	@Autowired
	CompanionRepository companionRepo;
	
	@Override
	public List<Companion> findAllByOwner(User owner) {
		return companionRepo.findAllByOwner(owner);
	}

	@Override
	public List<Companion> findActiveByOwner(User owner) {
		return companionRepo.findNotSettleByOwner(owner);
	}

	@Override
	public List<Companion> findAllByUser(User user) {
		return companionRepo.findAllByUser(user);
	}

	@Override
	public List<Companion> findActiveByUser(User user) {
		return companionRepo.findNotSettleByUser(user);
	}

	@Override
	public Double getTotalUserHave(User user) {
		return getTotalAmount(this.findActiveByOwner(user));
	}

	@Override
	public Double getTotalUserOwn(User user) {
		return getTotalAmount(this.findActiveByUser(user));
	}

	@Override
	public Double getTotalAmount(List<Companion> companions) {
		Double total = 0.0;
		for(Companion c: companions){
			total += c.getAmount();
		}
		return total;
	}

	@Override
	public List<Companion> findAllByReceipt(Receipt receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Companion> findActiveByReceipt(Receipt receipt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Companion getCompanionByCompanionId(long id) {
		// TODO Auto-generated method stub
		Companion comp = companionRepo.findOne(id);
		
		return comp;
	}
	
	public void deleteCompanion(Companion comp) {
		companionRepo.delete(comp);
	}

	@Override
	public void save(Companion comp) {
		companionRepo.save(comp);
		
	}

}
