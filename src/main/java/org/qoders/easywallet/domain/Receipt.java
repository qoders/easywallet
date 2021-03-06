package org.qoders.easywallet.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Simple receipt object
 * @author Nhu Trinh
 *
 */
@Entity
@Table(name="receipt")
public class Receipt implements Serializable {
	private static final long serialVersionUID = -3143441576750543429L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User owner;
	
	@Column(nullable=false, length=255)
	private String title;
	
	@Column(nullable=true, length=2000)
	private String description;
	
	private Double total;
	private String imagePath;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="receipt_date", nullable=false)
	private Date date;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Companion> companions;
	
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
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public List<Companion> getCompanions() {
		return companions;
	}
	public void setCompanions(List<Companion> companions) {
		this.companions = companions;
	}
	
	public void addCompanion(Companion companion){
		this.companions.add(companion);
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@PrePersist
	protected void onCreate() {
	    this.date = new Date();
	}
	
	public String toString(){
		return this.title;
	}
}
