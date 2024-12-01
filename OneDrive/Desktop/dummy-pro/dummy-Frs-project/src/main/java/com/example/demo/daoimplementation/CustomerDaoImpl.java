package com.example.demo.daoimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.CustomerDao;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

	
    @Override
    public Optional<Customer> findById(short customerId) {
        return customerRepository.findById(customerId);
    }
    
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
    
    
    
    
    
}

	
	

