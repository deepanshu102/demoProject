package com.niit.indigo.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.indigo.dao.UserRepository;
import com.niit.indigo.model.Users;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userDao;

	public void save(Users customer) {
		String plainPassword=customer.getPassword();
		String cipherPassword=encryptPass(plainPassword);
		customer.setPassword(cipherPassword);
		userDao.save(customer);
	}
	
	private String encryptPass(String pass) {
		Base64.Encoder encoder = Base64.getEncoder();
		String normalString = pass;
		String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
		return encodedString;
	}

	public Users login(Users loginUser) {
	
		String plainPassword=loginUser.getPassword();
		String cipherPassword=encryptPass(plainPassword);
		Optional<Users> user=userDao.findByEmailAndPassword(loginUser.getEmail(),cipherPassword);
		if(user.isPresent())
		{
			return user.get();
		}
		else
		{
		
			return null;
		}
	}

	public List<Users> findByFromDateTODate(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return userDao.findByRegisteredDateBetween(fromDate,toDate);
	}

	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
}
