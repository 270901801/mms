package com.ssm.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.ssm.pojo.BigType;
import com.ssm.pojo.Products;
import com.ssm.pojo.SmallType;

public interface ProductsService {
	List<Products> selectAll(RowBounds rowBounds);

	List<Products> selectAll();

	int selectCount();

	Products selectById(int id);
	

	List<Products> selectByName(String keyword);

	List<BigType> selectBigType();

	List<SmallType> selectSmallTypeByBigType(int bid);

	List<BigType> selectSmallType();

	int updateProducts(Products products);

	void insertProduct(Products products);

	<T> List<Products> selectByNameAndType(Map<String, T> map);
}
