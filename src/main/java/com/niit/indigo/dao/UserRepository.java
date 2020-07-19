package com.niit.indigo.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.indigo.model.Users;

public interface UserRepository extends JpaRepository<Users, String> {

	Optional<Users>
	findByEmailAndPassword(String email, String password);

	List<Users> findByRegisteredDateBetween(Date fromDate, Date toDate);

}
