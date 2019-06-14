package com.ssm.service;

import java.util.List;

import com.ssm.pojo.SmallType;

public interface SmallTypeService {

	void insert(SmallType smallType);

	List<SmallType> selectByBid(int bid);

	List<SmallType> selectAll();

}
