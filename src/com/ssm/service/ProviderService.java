package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Admin;
import com.ssm.pojo.Products;
import com.ssm.pojo.Provider;

public interface ProviderService {

	void insert(Provider provider);

	List<Provider> selectAll();



	
}
