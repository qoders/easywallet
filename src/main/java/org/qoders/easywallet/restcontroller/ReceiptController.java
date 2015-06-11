package org.qoders.easywallet.restcontroller;

import java.io.File;

import javax.servlet.ServletContext;

import org.qoders.easywallet.domain.Receipt;
import org.qoders.easywallet.service.ReceiptScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handle all receipt related request
 * @author Nhu Trinh
 *
 */
@RestController
@RequestMapping(value = "api/receipt")
public class ReceiptController {
	@Autowired
	ReceiptScanService receiptScanner;
	
	@Autowired 
	ServletContext servletContext;
	
	/**
	 * 
	 * @param receipPath the receipt image's relative path to, begin with {upload-user-id}/{image-name}.jpg
	 * @return
	 */
	@RequestMapping(value="/scan", method=RequestMethod.POST)
	public ResponseEntity<Receipt> scan(@RequestParam(value="receiptPath") String receiptPath){
		//Return object
		Receipt receipt;
		//Security: hecker may pass .. in path to exploit data, remove it
		receiptPath = receiptPath.replace("..", "");
		String fullPath = servletContext.getRealPath("/media/receipts/" + receiptPath);
		//Check for file exists
		File f = new File(fullPath);
		if(f.exists() && f.isFile()){
			receipt = receiptScanner.getReceiptFromImage(fullPath);
			return new ResponseEntity<Receipt>(receipt, HttpStatus.OK);
		}else{
			return new ResponseEntity<Receipt>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
