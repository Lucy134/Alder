package com.alder.locpol.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Bills")
public class BoardBill {
	@Id
	@Column
	private String billNum;
	
	@Column(length = 300)
	private String title;
	@Column(length = 3000)
	private String text;
	@Column
	private String sponser;
	@Column
	private String billLink;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSponser() {
		return sponser;
	}
	public void setSponser(String string) {
		this.sponser = string;
	}
	public String getBillLink() {
		return billLink;
	}
	@Override
	public String toString() {
		return "BoardBill [title=" + title + ", text=" + text + ", sponser=" + sponser + ", billLink=" + billLink + "]";
	}
	public void setBillLink(String billLink) {
		this.billLink = billLink;
	}
	public String getBillNum() {
		return billNum;
	}
	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}
}
