package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Customer;

public interface CustomerDao {
	List<Customer> getAllCustomer();
	Optional<Customer> findById(short customerId); // New method for finding a customer by ID
    Customer save(Customer customer); 

}
