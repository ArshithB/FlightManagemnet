package com.spring.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FlightDetails")
public class Flight {
	
	@Id
	@Column(name ="FlightId")
	private int fId;
	@Column (name ="FlightName")
	private String fName;
	
	//----//
	public Flight(int fId, String fName) {
		super();
		this.fId = fId;
		this.fName = fName;
	}
	public Flight() {
		super();
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
}
