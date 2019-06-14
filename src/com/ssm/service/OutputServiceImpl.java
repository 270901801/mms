package com.ssm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.AdminMapper;
import com.ssm.mapper.OutputMapper;
import com.ssm.pojo.Admin;
import com.ssm.pojo.Input;
import com.ssm.pojo.Output;



@Service("outputService")
@Transactional
public class OutputServiceImpl implements OutputService{
	
	@Autowired
	private OutputMapper outputMapper;

	@Override
	public int insert(Output output) {
		return outputMapper.insert(output);
	}

	@Override
	public List<Output> selectAll() {
		return outputMapper.selectAll();
	}

	

	@Override
	public <T> List<Output> selectByKeyword(Map<String, T> map) {
		return outputMapper.selectByKeyword(map);
	}

	@Override
	public List<Output> selectByGroupName() {
		return outputMapper.selectByGroupName();
	}
	
	
}
