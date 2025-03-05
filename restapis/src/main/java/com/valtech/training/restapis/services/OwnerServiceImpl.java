package com.valtech.training.restapis.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.restapis.entities.Owner;
import com.valtech.training.restapis.entities.Watch;
import com.valtech.training.restapis.repos.OwnerRepo;
import com.valtech.training.restapis.repos.WatchRepo;
import com.valtech.training.restapis.vos.OwnerVO;
import com.valtech.training.restapis.vos.WatchVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)

public class OwnerServiceImpl implements OwnerService {
	
	@Autowired
	private OwnerRepo ownerRepo;
	
	@Autowired
	private WatchRepo watchRepo;
	
//	
//	from OwnerVO get the owner
//	create Owner on DB
//	create OwnerVO from Owner
//	return OwnerVO.
	
	@Override
	public OwnerVO createOwner(OwnerVO ownerVO) {
//	return OwnerVO.from(ownerRepo.save(owner.toOwner()))  ;
	Owner owner = ownerVO.toOwner();
	owner = ownerRepo.save(owner);
	return OwnerVO.from(owner);
	
	
	}
	

	@Override
	public OwnerVO getOwner(long id) {
		
//		from OwnerVO get the Owner
//		update owner on DB
//		return owner
		
		Owner owner1= ownerRepo.getReferenceById(id);
		return OwnerVO.from(owner1);
		
//		return OwnerVO.from(ownerRepo.getReferenceById(id));
	}

		@Override
		public List<OwnerVO> getOwnerByName(String name) {
		return OwnerVO.toOwnerVO(ownerRepo.findAllByName(name));
	}

	@Override
	public OwnerVO updateOwner(long id, OwnerVO owner) {
		Owner owner1 = ownerRepo.getReferenceById(id);
		owner.updateOwnerFromVO(owner1);
		return OwnerVO.from(ownerRepo.save(owner1));

	}
	
	@Override
	public List<OwnerVO> getOwners() {
		List<Owner> owners = ownerRepo.findAll();
		return owners.stream().map(o->OwnerVO.from(o)).collect(Collectors.toList()) ;
	}


	@Override
	public OwnerVO addWatchesToOwner(long id, List<Long> watches) {
	final Owner owner = ownerRepo.getReferenceById(id);
		watches.stream().forEach(wid->owner.addWatch(watchRepo.getReferenceById(wid)));
		Owner owner1 = ownerRepo.save(owner);
		return OwnerVO.from(owner) ;
		
	}
	
	
	

}
