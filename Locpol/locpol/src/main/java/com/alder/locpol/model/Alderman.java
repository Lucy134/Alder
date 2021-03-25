package com.alder.locpol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="Alderman")
public class Alderman {
	
	@Column
	private String Name;
	@Id
	@Column
	private String ward;
	@Column
	private String phone;
	@Column
	private String twitter;
	@Column
	private String facebook;
	
	//how to manually set twitter and facebook?  Make profile on site? (bad kinda lazy but nessecary?)
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "Alderman [Name=" + Name + ", ward=" + ward + ", twitter=" + twitter + ", facebook=" + facebook + "]";
	}
	
	

}
