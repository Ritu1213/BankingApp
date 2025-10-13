package com.Application.BankingApp.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Application.BankingApp.Entity.Transaction;
import com.Application.BankingApp.Entity.User;
import com.Application.BankingApp.Repository.TransactionRepository;
import com.Application.BankingApp.Repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class TransactionService {
       private final TransactionRepository transactionRepository;
       private final UserRepository userRepository;

	public TransactionService(TransactionRepository transactionRepository,UserRepository userRepository) {
		super();
		this.transactionRepository = transactionRepository;
		this.userRepository = userRepository;
	}
       
	

	public List<Transaction> findByUserId(Long userId) {
		// TODO Auto-generated method stub
		return transactionRepository.findByUserId(userId) ;
	}



	public Transaction createTransaction(Long userId,Transaction transaction) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
		
		transaction.setUser(user);
		transaction.setTimestamp(LocalDateTime.now());
		return transactionRepository.save(transaction);
	}
}
