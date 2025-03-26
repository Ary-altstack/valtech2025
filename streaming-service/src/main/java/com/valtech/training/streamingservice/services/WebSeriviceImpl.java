package com.valtech.training.streamingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.repos.WebSeriesRepo;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@Service
@Transactional
public class WebSeriviceImpl {
	
	@Autowired
	private WebSeriesRepo webSeriesRepo;
	
	public WebSeriesVO createOrUpdate(WebSeriesVO w) {
		return WebSeriesVO.from(webSeriesRepo.save(w.to()));
	}
	
	public List<WebSeriesVO> getAllWebSeries(){
		return WebSeriesVO.from(webSeriesRepo.findAll());
	}
	
	public WebSeriesVO getWebSeires(long id){
		return WebSeriesVO.from(webSeriesRepo.getReferenceById(id));
	}
	
	public List<WebSeriesVO> getAllByEpisodeCount(int count){
		return WebSeriesVO.from(webSeriesRepo.findAllByEpisodeCount(count));
		
	}
	
}
