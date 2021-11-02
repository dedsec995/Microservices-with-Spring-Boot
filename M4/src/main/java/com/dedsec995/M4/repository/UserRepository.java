package com.dedsec995.M4.repository;

import java.sql.Timestamp;
import java.util.*;
import com.dedsec995.M4.model.*;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;


public interface UserRepository extends CassandraRepository<User, String> {
	

	@Query(value="SELECT * FROM Uswer WHERE vin=?0")
	public List<User> findByvin(String vin);
	
	@Query(value="SELECT * FROM User WHERE verify=?0 ALLOW FILTERING")
	public List<User> findbyVerify(String verify);
	
	@AllowFiltering
	public List<User> findBySpeedGreaterThan(int speed);
	
	@Query(value="SELECT * FROM User WHERE alert=?0 ALLOW FILTERING")
	public List<User> findbyAlert(String alert);
	
	@Query(value="SELECT * FROM User WHERE timest=?0 ALLOW FILTERING")
	public List<User> findbyTimeStamp(Timestamp timest);
	
}
