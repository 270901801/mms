package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.pojo.Admin;
import com.ssm.pojo.Input;
import com.ssm.pojo.Products;

public interface InputService {

	int insert(Input input);
	List<Input> selectAll();
	<T> List<Input> selectByKeyword(Map<String, T> map);
	List<Input> selectByGroupName();
}
