package com.ta.spring.code.faker.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.ta.spring.code.TA_Spring_Framework.pojo.files.Users;

public class User {

	public static void main(String[] args) {
		List<Users> users = new ArrayList<Users>();
		Faker faker = new Faker();
		for (int i = 0; i < 5; i++) {
			users.add(Users.builder().id(i).name(faker.name().fullName()).dob(LocalDate.now().minusYears(30+i)).build());
		}
		System.out.println(users); 
	}

}
