package com.valtech.assignment.inventory_management.vos;

import com.valtech.assignment.inventory_management.entities.Customer;
import com.valtech.assignment.inventory_management.entities.Customer.AppStatus;

public record CustomerVO ( String name, int age,String address,String permanentAddress){
	
	
	public Customer to() {
//		AppStatus appStat = AppStatus.valueOf(appStatus);
		System.err.println("Bhailaa"+ permanentAddress());
		return new Customer (name,age,address,permanentAddress,AppStatus.ENABLE);

	}
	
	public static CustomerVO from(Customer cust) {
//		String appStat =  cust.getAppStatus().name();
		return new CustomerVO(cust.getName(),cust.getAge(),cust.getAddress(),cust.getPermanentAddress());
	}

}
