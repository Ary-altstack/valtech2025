
package com.valtech.training.registerservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.registerservice.entities.Subscription;
import com.valtech.training.registerservice.repos.SubscriptionRepo;
import com.valtech.training.registerservice.repos.UserRepo;
import com.valtech.training.registerservice.vos.SubscriptionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	private SubscriptionRepo subcriptionRepo;
	
	@Autowired
	private UserRepo userRepo;
	

	@Override
	public SubscriptionVO getSubscription(long id) {
		return SubscriptionVO.from(subcriptionRepo.getReferenceById(id));
	}

	@Override
	public List<SubscriptionVO> getAllSubscriptions() {
		return subcriptionRepo.findAll().stream().map(s-> SubscriptionVO.from(s)).collect(Collectors.toList());
	}

	@Override
	public SubscriptionVO saveOrUpdateSubscription(SubscriptionVO vo) {
//		List<User> users = userRepo.findAllById(vo.userId());
		Subscription subs = vo.to(userRepo.findAll());
		subcriptionRepo.save(subs);
		return SubscriptionVO.from(subs) ;
		
	}
	
	

}
