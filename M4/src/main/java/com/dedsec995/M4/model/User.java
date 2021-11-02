package com.dedsec995.M4.model;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Comparable<User>{
	
	public String vin;	
	public String verify;
	public int speed;
	public String alert;
	@PrimaryKey
	public Timestamp timest;

	
//	@PrimaryKey
//	public int vin;	
//	public String alert;
//	public int speed;
//	public String verified;
//	public Timestamp time;


	public User()
	{
		
	}

//	public User(int id, String name, String address, int age) {
//
//		this.id = id;
//		this.name = name;
//		this.address = address;
//		this.age = age;
//	}
	
//	public Vhcl(int v_id, int vin_num, int v_speed)
//	{
//		this.v_id =v_id;
//		this.vin_num = vin_num;
//		this.v_speed = v_speed;
//	}
	
	public User(String vin, String verify, int speed, String alert, Timestamp timest)
	{
		this.timest =timest;
		this.vin = vin;
		this.verify = verify;
		this.speed = speed;
		this.alert = alert;
	}
	
	
	
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public Timestamp getTimest() {
		return timest;
	}

	public void setTimest(Timestamp timest) {
		this.timest = timest;
	}

	@Override
	public String toString() {
		//return String.format("VIN=%s, Verified='%s', Speed='%sd', Alert=%s, Time=", this.vin, this.verify, this.speed, this.alert, +this.timest);
		return String.format("VIN= "+this.vin+" Verified= "+this.verify+" Speed= "+this.speed+" Alert= "+this.alert+" Time= "+this.timest);
	}

	@Override
	public int compareTo(User sort_ts) {
		
		return getTimest().compareTo(sort_ts.getTimest());
	}
	


}
