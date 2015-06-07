package org.qoders.easywallet.service;

import org.qoders.easywallet.domain.Receipt;

/**
 * Interface for receipt scanner
 * @author Nhu Trinh
 *
 */
public interface ReceiptScanService {
	
	/**
	 * Return a {@link Receipt} object from imagePath
	 * @param imagePath an absolute file path for image
	 * @return {@link Receipt}
	 */
	public Receipt getReceiptFromImage(String imagePath);
}
