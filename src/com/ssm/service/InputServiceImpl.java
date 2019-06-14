package com.ssm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.InputMapper;
import com.ssm.pojo.Input;



@Service("inputService")
@Transactional
public class InputServiceImpl implements InputService{
	
	@Autowired
	private InputMapper inputMapper;

	@Override
	public int insert(Input input) {
		return inputMapper.insert(input);
	}

	@Override
	public List<Input> selectAll() {
		return inputMapper.selectAll();
	}

	@Override
	public <T> List<Input> selectByKeyword(Map<String, T> map) {
		return inputMapper.selectByKeyword(map);
	}

	@Override
	public List<Input> selectByGroupName() {
		return inputMapper.selectByGroupName();
	}
	
	
}
