package com.skillstorm.cpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "records")
public class Record {
	
	@Id 				 									// specifies that this column is the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)		// specifies that the DB will provide values for this column (auto-incremented)
	@Column(name = "id") 									// specifies which column this variable goes with
	private int id;
	
	@Column(name = "owner")
	private String owner;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "total_revenue")
	private double total_revenue;
	
	@Column(name = "taxes_paid")
	private double taxes_paid;
	
	@Column(name = "taxes_owed")
	private double taxes_owed;
	@Column(name = "status")
	private String status;
	

	public Record() {
		super();
	}


	


	public Record(int id, String owner, String type, double total_revenue, double taxes_paid, double taxes_owed,
			String status) {
		super();
		this.id = id;
		this.owner = owner;
		this.type = type;
		this.total_revenue = total_revenue;
		this.taxes_paid = taxes_paid;
		this.taxes_owed = taxes_owed;
		this.status = status;
	}





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getRevenue() {
		return total_revenue;
	}


	public void setRevenue(double total_revenue) {
		this.total_revenue = total_revenue;
	}


	public double getTaxes_paid() {
		return taxes_paid;
	}


	public void setTaxes_paid(double taxes_paid) {
		this.taxes_paid = taxes_paid;
	}


	public double getTaxes_owed() {
		return taxes_owed;
	}


	public void setTaxes_owed(double taxes_owed) {
		this.taxes_owed = taxes_owed;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Record [id=" + id + ", owner=" + owner + ", type=" + type + ", total_revenue=" + total_revenue + ", taxes_paid="
				+ taxes_paid + ", taxes_owed=" + taxes_owed + ", status=" + status + "]";
	}


	

	
	

	

	

}
