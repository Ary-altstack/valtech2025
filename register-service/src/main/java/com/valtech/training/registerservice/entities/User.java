package com.valtech.training.registerservice.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "userSeq",allocationSize = 1)
	
	private long id;
	private String name;
	private String mobileNo;
	private String email;
	private boolean kid;
	
	@ManyToOne(targetEntity = Subscription.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id",name="subscription_id")
	private Subscription subscription;

	public User() {}

	public User(String name, String mobileNo, String email,Boolean kid) {
		this.name = name;
		this.mobileNo = mobileNo;
		this.email = email;
		this.kid = kid;
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public Subscription getSubscription() {
		return subscription;
	}
	
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public boolean isKid() {
		return kid;
	}

	public void setKid(boolean kid) {
		this.kid = kid;
	}
	
	

	
	
	
	
	
	
	

}
