package com.oop.service;

import java.util.List;

import com.oop.entity.CustomerEntity;

public interface CustomerService {
	public CustomerEntity getCustomer(Integer id);
	public List<CustomerEntity> getAllCustomer();
	public CustomerEntity addCustomer(CustomerEntity customer);
	public CustomerEntity  modifyCustomer(CustomerEntity customer);
	public void deleteCustomet(Integer id);
}
