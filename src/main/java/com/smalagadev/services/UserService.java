package com.smalagadev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smalagadev.models.User;
import com.smalagadev.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository dao;
	
	public List<User> findAll() {
		return dao.findAll();
	}
	
	public User upsert(User u) {
		Optional<User> exists = dao.findById(u.getId());
		if(exists.isPresent()) {
			User found = exists.get();
			found.setFirst_name(u.getFirst_name());
			found.setLast_name(u.getLast_name());
			found.setUsername(u.getUsername());
			found.setPassword(u.getPassword());
			return dao.save(found);
		} else {
			return dao.save(u);
		}
	}
}
