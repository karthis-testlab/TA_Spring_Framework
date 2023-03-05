package com.ta.spring.code.TA_Spring_Framework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ta.spring.code.TA_Spring_Framework.pojo.files.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

}
