package com.alder.locpol.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@Entity
@Table(name = "Users")
public class User {

	@Column(name = "first_name")
	private String fName;
	@Column(name = "last_name")
	private String lName;
	@Id
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Transient
	private String password2;
	@Column(name = "ward")
	private String ward;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

//	public Alderman getAlderman() {
//		return alderman;
//	}

//	public void setAlderman(Alderman alderman) {
//		this.alderman = alderman;
//	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

}
