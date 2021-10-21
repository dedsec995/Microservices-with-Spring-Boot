package com.dedsec995.M3.model;

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
	private String speed;
	private String alert;
		
	public User(String vin, String verified, String speed, String alert) {
		super();
		this.vin = vin;
		this.verified = verified;
		this.speed = speed;
		this.alert = alert;
	}
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getverified() {
		return verified;
	}
	public void setverified(String verified) {
		this.verified = verified;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getalert() {
		return alert;
	}
	public void setalert(String alert) {
		this.alert = alert;
	}	
}