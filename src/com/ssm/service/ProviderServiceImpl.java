package com.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.AdminMapper;
import com.ssm.mapper.ProductsMapper;
import com.ssm.mapper.ProviderMapper;
import com.ssm.pojo.Admin;
import com.ssm.pojo.Provider;



@Service("providerService")
@Transactional
public class ProviderServiceImpl implements ProviderService{

	@Autowired
	private ProviderMapper ProviderMappe;
	@Override
	public void insert(Provider provider) {
		ProviderMappe.insert(provider);
	}
	@Override
	public List<Provider> selectAll() {
		return ProviderMappe.selectAll();
	}
	
	
	
}
