package com.dedsec995.M4.repository;

import java.sql.Timestamp;
import java.util.*;
import com.dedsec995.M4.model.*;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;


public interface UserRepository extends CassandraRepository<User, String> {
	

	@Query(value="SELECT * FROM User WHERE vin=?0")
	public List<User> findByvin(String vin);
	
	@Query(value="SELECT * FROM User WHERE verified=?0 ALLOW FILTERING")
	public List<User> findbyVerified(String verified);
	
	@AllowFiltering
	public List<User> findBySpeedGreaterThan(int speed);
	
	@Query(value="SELECT * FROM User WHERE alert=?0 ALLOW FILTERING")
	public List<User> findbyAlert(String alert);
	
	@Query(value="SELECT * FROM User WHERE timest=?0 ALLOW FILTERING")
	public List<User> findbyTimeStamp(Timestamp timest);

	@AllowFiltering
    public List<User> findBySpeedBetween(int speed, int speed2);

	@AllowFiltering
	public List<User> findByTimestBetween(Timestamp timest, Timestamp timest2);	
	
}
