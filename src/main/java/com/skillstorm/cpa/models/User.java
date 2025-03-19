package com.skillstorm.cpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id 				 									// specifies that this column is the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// specifies that the DB will provide values for this column (auto-incremented)
	@Column(name = "id") 									// specifies which column this variable goes with
	private int id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "license")
	private String license;
	

	public User() {
		super();
	}

	public User(int id, String userName, String password, String license) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.license = license;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return password;
	}

	public void setUserType(String password) {
		this.password = password;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userType=" + password + ", license=" + license + "]";
	}

	

	

	

}
