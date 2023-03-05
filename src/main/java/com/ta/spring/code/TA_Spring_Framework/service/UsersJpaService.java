package com.ta.spring.code.TA_Spring_Framework.service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.ta.spring.code.TA_Spring_Framework.pojo.files.Users;
import com.ta.spring.code.TA_Spring_Framework.repository.UserRepository;

@Service
public class UsersJpaService {
	
	public static Faker faker = new Faker(Locale.ENGLISH);
	
	@Autowired
	UserRepository userDB;
	
	public List<Users> getAllUsers(){
		return userDB.findAll();
	}
	
	public Users getUser(int id) {
		Optional<Users> user = userDB.findById(id);	
		if(user.isEmpty()) {
			return null;
		}
		return user.get();
	}

	public Users addUser(Users user) {		
		return userDB.save(user);
	}

	public void deleteUser(int id) {
		userDB.deleteById(id);		
	}

	public Users updateUser(int id, Users users) {
		Users updateUser = null;
		Optional<Users> user = userDB.findById(id);
		if(user.isPresent()) {
			updateUser = user.get();
			updateUser.setId(users.getId());
			updateUser.setName(users.getName());
			updateUser.setDob(users.getDob());
		}
		return userDB.save(updateUser);
	}

}