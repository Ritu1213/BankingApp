package com.Application.BankingApp.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Transaction {

	  @Id 
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long transaction_id;
	 
	  private double  amount =0;
	  
	  private LocalDateTime timestamp;
	  
	    @ManyToOne
	    @JoinColumn(name = "user_id",nullable=false)
	  
	    private User user;

		public Long gettransaction_id() {
			return transaction_id;
		}

		public void settransaction_id(Long transaction_id) {
			this.transaction_id = transaction_id;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public LocalDateTime getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}

		public User getuser() {
			return user;
		}

		public void setUser(User user) {
			this.user= user;
		}
	    
	    
	  
}
