package org.qoders.easywallet.domain;

import java.io.Serializable;

/**
 * Simple receipt object
 * @author Nhu Trinh
 *
 */
public class Receipt implements Serializable {
	private static final long serialVersionUID = -3143441576750543429L;
	
	private String title;
	private String description;
	private Double total;
	private String items;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
}
