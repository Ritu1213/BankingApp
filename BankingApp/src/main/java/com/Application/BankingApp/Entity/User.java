package com.Application.BankingApp.Entity;



import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")  
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	  @Id 
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
	  
	@Column(name= "name")
	  private String name;
	 
	 @Column(name="email")
	  private String email;
	  
	 @Column(name="balance")
	  private double  balance =0;
	 
	 @Column(name="reward")
	  private double reward =0;
	 
	 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
	 @JsonIgnore
	 private List<Transaction> Transaction = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getReward() {
		return reward;
	}

	public void setReward(double newReward) {
		this.reward = newReward;
	}

	
	  
	
      
}
