package org.qoders.easywallet.service.impl;

import java.util.List;

import org.qoders.easywallet.domain.Receipt;
import org.qoders.easywallet.domain.User;
import org.qoders.easywallet.repository.ReceiptRepository;
import org.qoders.easywallet.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImpl implements ReceiptService{
	
	@Autowired
	ReceiptRepository receiptRepo;
	
	@Override
	public void createReceipt(Receipt receipt) {
		receiptRepo.save(receipt);
		
	}

	@Override
	public List<Receipt> findReceiptByUser(User user) {
		return receiptRepo.findByUser(user);
	}

	@Override
	public void removeReceipt(Receipt receipt) {
		receiptRepo.delete(receipt);
	}

}
