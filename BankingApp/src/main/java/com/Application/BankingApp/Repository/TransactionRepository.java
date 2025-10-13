package com.Application.BankingApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Application.BankingApp.Entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{

	 List<Transaction> findByUserId(@Param("userId") Long UserId);
}