package com.ssm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.SmallTypeMapper;
import com.ssm.pojo.SmallType;
@Service("smallTypeService")
@Transactional
public class SmallTypeServiceImpl implements SmallTypeService {
	
	private SmallTypeMapper smallTypeMapper;
	@Override
	public void insert(SmallType smallType) {
		smallTypeMapper.insert(smallType);
	}

	@Override
	public List<SmallType> selectByBid(int bid) {
		
		return smallTypeMapper.selectByBid(bid);
	}

	@Override
	public List<SmallType> selectAll() {
		return smallTypeMapper.selectAll();
	}
	
}
