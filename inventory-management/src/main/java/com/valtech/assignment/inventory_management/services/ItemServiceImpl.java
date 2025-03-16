package com.valtech.assignment.inventory_management.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.assignment.inventory_management.entities.Item;
import com.valtech.assignment.inventory_management.repo.ItemRepo;
import com.valtech.assignment.inventory_management.vos.ItemVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Override
	public ItemVO saveOrUpdate(ItemVO vo) {
		Item i = vo.to();
		i = itemRepo.save(i);
		return ItemVO.from(i);
	}
	
	@Override
	public ItemVO getItem(int id) {
		return ItemVO.from(itemRepo.getReferenceById(id));
	}
	
	@Override
	public List<ItemVO> getAll(){
		return itemRepo.findAll().stream().map(i->ItemVO.from(i)).collect(Collectors.toList());
	}
	

}
