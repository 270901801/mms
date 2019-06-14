package com.ssm.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.ProductsMapper;
import com.ssm.pojo.BigType;
import com.ssm.pojo.Products;
import com.ssm.pojo.SmallType;


@Service("productsService")
@Transactional
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsMapper productsMapper;
	@Override
	public List<Products> selectAll(RowBounds rowBounds) {
		return productsMapper.selectAll(rowBounds);
	}
	@Override
	public List<Products> selectAll() {
		return productsMapper.selectAll();
	}
	@Override
	public int selectCount() {
		return productsMapper.selectCount();
	}
	@Override
	public Products selectById(int id) {
		return productsMapper.selectProductById(id);
	}
	@Override
	public List<Products> selectByName(String keyword) {
		return productsMapper.selectProductByName(keyword);
	}
	@Override
	public List<BigType> selectBigType() {
		return productsMapper.selectBigType();
	}
	@Override
	public List<SmallType> selectSmallTypeByBigType(int bid) {
		return productsMapper.selectSmallTypeByBigType(bid);
	}
	@Override
	public List<BigType> selectSmallType() {
		return productsMapper.selectSmallType();
	}
	@Override
	public int updateProducts(Products products) {
		return productsMapper.updateProducts(products);
	}
	@Override
	public void insertProduct(Products products) {
		productsMapper.insertProduct(products);
	}
	@Override
	public <T> List<Products> selectByNameAndType(Map<String, T> map) {
		return productsMapper.selectByNameAndType(map);
	}

}
