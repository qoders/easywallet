package org.qoders.easywallet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReceiptController {
	
	@RequestMapping(value="")
	public String requestReceiptPage()
	{
		return "add_receipt";
	}

}
