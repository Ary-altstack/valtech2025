package com.valtech.training.registerservice.vos;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;

public record UserVO(long id, String name,String mobile,String email,Boolean kid,long subscriptionId) {
	
	public static UserVO from(User u) {
		return new UserVO(u.getId(),u.getName(),u.getMobileNo(),u.getEmail(),u.isKid(),u.getSubscription().getId());
	}
	
	public User to(Subscription sub) {
		User user =  new User(name,mobile,email,kid);
		user.setSubscription(sub);
		return user;
	}

}
