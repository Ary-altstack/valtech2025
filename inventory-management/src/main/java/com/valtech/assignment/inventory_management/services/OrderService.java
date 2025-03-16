package com.valtech.assignment.inventory_management.services;

import com.valtech.assignment.inventory_management.entities.LineOrder;
import com.valtech.assignment.inventory_management.entities.Order;

public interface OrderService {

	void saveOrder(Order o);

	void saveLineOrder(LineOrder lo);

}