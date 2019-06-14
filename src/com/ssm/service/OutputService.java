package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.pojo.Output;

public interface OutputService {

	int insert(Output output);
	List<Output> selectAll();
	<T> List<Output> selectByKeyword(Map<String, T> map);
	List<Output> selectByGroupName();
}
