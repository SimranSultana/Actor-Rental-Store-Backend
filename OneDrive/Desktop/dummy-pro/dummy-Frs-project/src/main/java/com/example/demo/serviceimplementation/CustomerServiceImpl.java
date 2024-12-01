package com.example.demo.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.dto.ResponseStructure;
import com.example.demo.entity.Customer;
import com.example.demo.exception.DataNotFoundException;
import com.example.demo.service.CustomerService;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public ResponseStructure<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerDao.getAllCustomer();
        ResponseStructure<List<Customer>> response = new ResponseStructure<>();
        if (customers.isEmpty()) {
            response.setStatuscode(HttpStatus.NOT_FOUND.value());
            response.setMessage("No customers found");
        } else {
            response.setStatuscode(HttpStatus.OK.value());
            response.setMessage("Customers retrieved successfully");
            response.setData(customers);
        }
        return response;
    }
    
    
    
    @Override
    @Transactional // Wrap in transaction for data integrity
    public ResponseStructure<Customer> updateCustomer(short customerId, Customer updatedCustomer) {
        ResponseStructure<Customer> response = new ResponseStructure<>();
        try {
            Customer existingCustomer = customerDao.findById(customerId)
                    .orElseThrow(() -> new DataNotFoundException("Customer not found with ID: " + customerId));

            // Update fields - Consider using BeanUtils.copyProperties for more robust updates
            existingCustomer.setFirst_name(updatedCustomer.getFirst_name());
            existingCustomer.setLast_name(updatedCustomer.getLast_name());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            // Update other fields as needed...

            Customer savedCustomer = customerDao.save(existingCustomer);
            response.setStatuscode(HttpStatus.OK.value());
            response.setMessage("Customer updated successfully");
            response.setData(savedCustomer);
        } catch (DataNotFoundException e) {
            response.setStatuscode(HttpStatus.NOT_FOUND.value());
            response.setMessage(e.getMessage());
        } catch (Exception e) { // Catch other potential exceptions (e.g., database errors)
            response.setStatuscode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("An error occurred while updating the customer: " + e.getMessage());
        }
        return response;
    }
}

