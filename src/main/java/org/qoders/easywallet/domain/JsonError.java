package org.qoders.easywallet.domain;

import java.io.Serializable;

/**
 * Return error inform of JSON
 * @author Nhu Trinh
 *
 */
public class JsonError implements Serializable {
	private static final long serialVersionUID = -5884981490483104847L;

	public boolean error = true;
	public String message;
	
	public JsonError(Exception ex){
		this.message = ex.getMessage();
	}
}
