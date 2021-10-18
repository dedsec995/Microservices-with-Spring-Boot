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
	private String flg;
	private String speed;
	private String alt;
		
	public User(String vin, String flg, String speed, String alt) {
		super();
		this.vin = vin;
		this.flg = flg;
		this.speed = speed;
		this.alt = alt;
	}
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getFlg() {
		return flg;
	}
	public void setFlg(String flg) {
		this.flg = flg;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}	
}