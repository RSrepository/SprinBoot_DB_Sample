package com.r_saiki.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.r_saiki.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
