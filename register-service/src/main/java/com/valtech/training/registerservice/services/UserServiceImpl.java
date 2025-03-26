package com.valtech.training.registerservice.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.entities.User;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.UserVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private SubscriptionRepo subscriptionRepo;
	
//	@Override
//	public UserVO loginUser(UserVO uvo) {
////		Subscription s = subscriptionService.getSubscription(user.subscriptionId()).to(List<User>)
////		return UserVO.from(userRepo.save(user.to(sub)));
////		return UserVO.from(userRepo.save(uvo.to(subscriptionRepo.getReferenceById(uvo.subscriptionId()))));
//		
//	}
	
	@Override
	public UserVO getUser(long id) {
		return UserVO.from(userRepo.getReferenceById(id));
		
	}
	
	@Override
	public List<UserVO> getAllUsers() {
		return userRepo.findAll().stream().map(u->UserVO.from(u)).collect(Collectors.toList());
	}
	
	
	public UserVO registerUser(UserVO vo) {
		Subscription sc = new Subscription();
		sc.setAmount(99);
		sc.setSubsscriptionStart(LocalDate.now());
		sc.setSubscriptionStop(LocalDate.now().plusYears(1));
		subscriptionRepo.save(sc);
		User u = vo.to(sc);
		userRepo.save(u);
		return UserVO.from(u);
		
	}
	
	
	

	

	
	
	
	

}
