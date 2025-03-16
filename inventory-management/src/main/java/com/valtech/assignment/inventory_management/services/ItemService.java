package com.valtech.assignment.inventory_management.services;

import java.util.List;

import com.valtech.assignment.inventory_management.vos.ItemVO;

public interface ItemService {

	ItemVO saveOrUpdate(ItemVO vo);

	ItemVO getItem(int id);

	List<ItemVO> getAll();

}