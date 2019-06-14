package com.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.BigTypeMapper;
import com.ssm.pojo.BigType;

@Service("bigTypeService")
@Transactional
public class BigTypeServiceImpl implements BigTypeService {

	@Autowired
	private BigTypeMapper bigTypeMapper;
	@Override
	public void insert(BigType bigType) {
		bigTypeMapper.insert(bigType);
	}

}
