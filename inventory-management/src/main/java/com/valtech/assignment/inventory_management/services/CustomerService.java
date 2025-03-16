package com.valtech.assignment.inventory_management.services;

import com.valtech.assignment.inventory_management.vos.CustomerVO;

public interface CustomerService {

	CustomerVO saveOrUpdate(CustomerVO vo);

	CustomerVO getCustomer(int id);

}