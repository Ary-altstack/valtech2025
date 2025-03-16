package com.valtech.assignment.inventory_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.assignment.inventory_management.entities.LineOrder;

@Repository
public interface LineOrderRepo extends JpaRepository<LineOrder, Integer>{

}
