package com.valtech.training.registerservice.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Subscription {
	

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sub_seq")
	@SequenceGenerator(name = "sub_seq", sequenceName = "subSeq",allocationSize = 1)
	private long id;
	private int amount;
	private LocalDate subsscriptionStart;
	private LocalDate subscriptionStop;
	
	@OneToMany(targetEntity = User.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<User> users;

	
	public Subscription() {}


	public Subscription(int amount, LocalDate subsscriptionStart, LocalDate subscriptionStop) {
		this.amount = amount;
		this.subsscriptionStart = subsscriptionStart;
		this.subscriptionStop = subscriptionStop;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public LocalDate getSubsscriptionStart() {
		return subsscriptionStart;
	}


	public void setSubsscriptionStart(LocalDate subsscriptionStart) {
		this.subsscriptionStart = subsscriptionStart;
	}


	public LocalDate getSubscriptionStop() {
		return subscriptionStop;
	}


	public void setSubscriptionStop(LocalDate subscriptionStop) {
		this.subscriptionStop = subscriptionStop;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
}
