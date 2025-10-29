package com.Application.BankingApp.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Application.BankingApp.Entity.Transaction;
import com.Application.BankingApp.Entity.User;
import com.Application.BankingApp.Repository.TransactionRepository;
import com.Application.BankingApp.Repository.UserRepository;

import jakarta.transaction.Transactional;
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



	@Transactional
	public Transaction createTransaction(Long userId,Transaction transaction) {
		User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
		
			if(user.getBalance() < transaction.getAmount()) {
				throw new RuntimeException("Insufficiant balance!");
			}
			else {
				
				double newBalance = user.getBalance() - transaction.getAmount();
			    user.setBalance(newBalance);
			    double newReward= user.getReward() + (10 * transaction.getAmount());
			    user.setReward(newReward);
			}
		
		
		transaction.setUser(user);
		transaction.setTimestamp(LocalDateTime.now());
		userRepository.save(user);
		return transactionRepository.save(transaction);
	}
			
}
