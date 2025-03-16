package com.valtech.assignment.inventory_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.assignment.inventory_management.entities.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	

}
