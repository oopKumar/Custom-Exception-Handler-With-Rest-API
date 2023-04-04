package com.oop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop.entity.CustomerEntity;
import com.oop.service.CustomerService;

@RestController
@RequestMapping("/www.customer.com")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/save")
	public ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerEntity customer) {
		CustomerEntity addCustomer = customerService.addCustomer(customer);
		return  new ResponseEntity<>(addCustomer,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<CustomerEntity> getCustomer(Integer id) {
		CustomerEntity Customer = customerService.getCustomer(id);
		return  new ResponseEntity<>(Customer,HttpStatus.OK);
		
	}
	
	@GetMapping("/customer")
	public ResponseEntity<List<CustomerEntity>> getAllCustomer() {
		 List<CustomerEntity> allCustomer = customerService.getAllCustomer();
		return  new ResponseEntity<>(allCustomer,HttpStatus.OK);	
	}
	
	
	
	  @PutMapping("/modify")
	  public ResponseEntity<CustomerEntity>modifyCustomer(@RequestBody CustomerEntity customer) { 
		  CustomerEntity modifyCustomer = customerService.modifyCustomer(customer); 
		  return new ResponseEntity<>(modifyCustomer,HttpStatus.CREATED);  
	  }
	 
	  @DeleteMapping("/delete/{id}")
	  public void deleteCustuomer(Integer id) {
		  customerService.deleteCustomet(id);
	  }
	

}
