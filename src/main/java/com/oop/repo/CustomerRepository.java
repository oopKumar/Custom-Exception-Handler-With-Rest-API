package com.oop.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oop.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

}
