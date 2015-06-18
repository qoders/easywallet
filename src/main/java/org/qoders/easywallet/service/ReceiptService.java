package org.qoders.easywallet.service;

import java.util.List;

import org.qoders.easywallet.domain.Group;
import org.qoders.easywallet.domain.Receipt;
import org.qoders.easywallet.domain.User;

public interface ReceiptService {
	public void createReceipt(Receipt receipt);
	public List<Receipt> findReceiptByUser(User user);
	public void removeReceipt(Receipt receipt);
}
