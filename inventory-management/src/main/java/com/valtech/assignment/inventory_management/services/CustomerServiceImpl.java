package com.valtech.assignment.inventory_management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.inventory_management.entities.Customer;
import com.valtech.assignment.inventory_management.repo.CustomerRepo;
import com.valtech.assignment.inventory_management.vos.CustomerVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl implements CustomerService  {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public CustomerVO saveOrUpdate(CustomerVO vo) {
		Customer cust = vo.to();
		cust = customerRepo.save(cust);
		return CustomerVO.from(cust);
	}
	
	@Override
	public CustomerVO getCustomer(int id) {
		return CustomerVO.from(customerRepo.getReferenceById(id)) ;
		
	}

}
