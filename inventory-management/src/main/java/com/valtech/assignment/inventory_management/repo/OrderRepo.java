package com.valtech.assignment.inventory_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.assignment.inventory_management.entities.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
