package com.dedsec995.M3.model;

import java.sql.Time;
import java.sql.Timestamp;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@PrimaryKey
	private String vin;
	private String verified;
	private int speed;
	private String alert;
	private Timestamp timest;
		
	public User(String vin, String verified, int speed, String alert,Timestamp timest) {
		super();
		this.vin = vin;
		this.verified = verified;
		this.speed = speed;
		this.alert = alert;
		this.timest = timest;
	}
	
	public String getVin() {
		return vin;
	}
	public String getverified() {
		return verified;
	}
	public Timestamp getTimest() {
		return timest;
	}
	public int getSpeed() {
		return speed;
	}
	public String getalert() {
		return alert;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setalert(String alert) {
		this.alert = alert;
	}	
	public void settimest(Timestamp timest) {
		this.timest = timest;
	}	
	public void setVin(String vin) {
		this.vin = vin;
	}
	public void setverified(String verified) {
		this.verified = verified;
	}
}