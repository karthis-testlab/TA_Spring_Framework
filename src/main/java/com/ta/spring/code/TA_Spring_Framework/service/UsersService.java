package com.ta.spring.code.TA_Spring_Framework.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.ta.spring.code.TA_Spring_Framework.pojo.files.Users;

@Service
public class UsersService {
	
	public static List<Users> users = new ArrayList<Users>();
	public static Faker faker = new Faker();
	public static int id = 0;
	
	static {
		/*users.add(Users.builder().id(++id).name("Karthikeyan").dob(LocalDate.now().minusYears(34)).build());
		users.add(Users.builder().id(++id).name("Gaj").dob(LocalDate.now().minusYears(37)).build());
		users.add(Users.builder().id(++id).name("Sabitha").dob(LocalDate.now().minusYears(35)).build());
		users.add(Users.builder().id(++id).name("Hare").dob(LocalDate.now().minusYears(35)).build());*/
		for (int i = 0; i < 5; i++) {
			users.add(Users.builder().id(++id).name(faker.name().fullName()).dob(LocalDate.now().minusYears(30+i)).build());
		}
	}
	
	public List<Users> getAllUsers(){
		return users;
	}
	
	public Users getUser(int id) {
		return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
	}

}