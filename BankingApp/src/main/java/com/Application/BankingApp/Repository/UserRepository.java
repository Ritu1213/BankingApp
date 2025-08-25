package com.Application.BankingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Application.BankingApp.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	

}
