package com.dedsec995.M3.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import com.dedsec995.M3.model.User;

public interface UserRepository extends CassandraRepository<User, String> {

	
}
