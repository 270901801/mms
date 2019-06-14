package com.ssm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.ssm.pojo.Admin;
import com.ssm.pojo.BigType;
import com.ssm.pojo.Products;
import com.ssm.pojo.SmallType;

public interface ProductsMapper {
    

    List<Products> selectAll(RowBounds rowBounds);
    
    int selectCount();

	List<Products> selectAll();

	Products selectProductById(int id);

	List<Products> selectProductByName(String keyword);

	List<BigType> selectBigType();

	List<SmallType> selectSmallTypeByBigType(int bid);

	List<BigType> selectSmallType();

	int updateProducts(Products products);

	void insertProduct(Products products);

	<T> List<Products> selectByNameAndType(Map<String, T> map);
    
    

   
}