package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ResponseStructure;
import com.example.demo.entity.Customer;

public interface CustomerService {

	 ResponseStructure<List<Customer>> getAllCustomers();
	 ResponseStructure<Customer> updateCustomer(short customerId, Customer updatedCustomer);
}
