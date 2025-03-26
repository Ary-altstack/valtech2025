package com.valtech.training.registerservice.vos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record SubscriptionVO(long id, int amount, String subscriptionStart,String subscriptionStop,List<Long> userId) {
	
	
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public static SubscriptionVO from (Subscription subs) {
		String startDate = subs.getSubsscriptionStart().format(FORMATTER);
		String endDate = subs.getSubscriptionStop().format(FORMATTER);
		return new SubscriptionVO(subs.getId(),subs.getAmount(),startDate, endDate, subs.getUsers().stream().map(u->u.getId()).collect(Collectors.toList())) ;
	}
	
	public Subscription to(List<User> users) {
		LocalDate startDate = LocalDate.parse(subscriptionStart,FORMATTER);
		LocalDate endDate = LocalDate.parse(subscriptionStop,FORMATTER);
		Subscription subs =new Subscription (amount,startDate,endDate);
		subs.setUsers(users);
		return subs ;
		
	}
	
	
		
	

}
