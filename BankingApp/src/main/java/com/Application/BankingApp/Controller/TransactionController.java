package com.Application.BankingApp.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Application.BankingApp.Entity.Transaction;
import com.Application.BankingApp.Entity.User;
import com.Application.BankingApp.Service.TransactionService;
import com.Application.BankingApp.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

private final TransactionService transactionService ;
	
	
	public TransactionController( TransactionService transactionService) {
		super();
		this.transactionService =transactionService;
	}

	@PostMapping("/user/{userId}")
	public Transaction createTransaction(@PathVariable Long userId, @RequestBody Transaction transaction) {
		 
	    Transaction newTransaction =  transactionService.createTransaction(userId,transaction);
		return newTransaction;
	}
	
	
	
	@GetMapping("/user/{userId}")
	public List<Transaction> findByUserId(@PathVariable("userId") Long UserId){
		return  transactionService.findByUserId(UserId) ;
		
	}
}
