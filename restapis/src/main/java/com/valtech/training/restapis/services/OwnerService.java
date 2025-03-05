package com.valtech.training.restapis.services;

import java.util.List;

import com.valtech.training.restapis.vos.OwnerVO;
import com.valtech.training.restapis.vos.WatchVO;

public interface OwnerService {

	OwnerVO createOwner(OwnerVO owner);

//	OwnerVO updateOwner(Long id, OwnerVO name);
	
//	OwnerVO updateOwner(long id, OwnerVO owner);

	OwnerVO getOwner(long id);

	List<OwnerVO> getOwnerByName(String name);

	OwnerVO updateOwner(long id, OwnerVO owner);

	List<OwnerVO> getOwners();

	OwnerVO addWatchesToOwner(long id, List<Long> watches);





}