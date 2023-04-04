package com.oop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oop.entity.CustomerEntity;
import com.oop.exception.CustomerNotFoundException;
import com.oop.repo.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public CustomerEntity getCustomer(Integer id) {
		Optional<CustomerEntity> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			return customer.get();

		} else {
			throw new CustomerNotFoundException("Customer Not Found Exception");

		}

	}


	public List<CustomerEntity> getAllCustomer() {
		List<CustomerEntity> customer = customerRepository.findAll();
		if(!customer.isEmpty()) {
		return customer;	
		}else {
		throw new CustomerNotFoundException("Customer Not Found Exception");	
		}

	}


	public CustomerEntity addCustomer(CustomerEntity customer) {
		CustomerEntity cust = customerRepository.save(customer);
		return cust;
	}


	public CustomerEntity modifyCustomer(CustomerEntity customer) {
		
		Optional<CustomerEntity> cust = customerRepository.findById(customer.getId());
		if(cust.isPresent()) {
			CustomerEntity c = customerRepository.save(customer);
			return c;
		}else {
			throw new CustomerNotFoundException("Customer Not Found For Update");
		}
	}
	public void deleteCustomet(Integer id) {
		
		Optional<CustomerEntity> customer = customerRepository.findById(id);
		if(customer.isPresent()) {
			customerRepository.deleteById(id);
		}else {
			throw new CustomerNotFoundException("Customer Not Found For Delete");
		}
		
	}

}
