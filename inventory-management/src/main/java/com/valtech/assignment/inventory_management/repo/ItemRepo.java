package com.valtech.assignment.inventory_management.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.assignment.inventory_management.entities.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

}
