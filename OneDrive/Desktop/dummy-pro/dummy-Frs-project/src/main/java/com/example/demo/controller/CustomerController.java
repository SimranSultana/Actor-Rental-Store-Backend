package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseStructure;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/api") // Using POST, although GET is more standard for retrieval
    public ResponseEntity<ResponseStructure<List<Customer>>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
       
    @PutMapping("/{customerId}")
    public ResponseEntity<ResponseStructure<Customer>> updateCustomer(
            @PathVariable short customerId, @RequestBody Customer updatedCustomer) {
        ResponseStructure<Customer> response = customerService.updateCustomer(customerId, updatedCustomer);
        return ResponseEntity.status(response.getStatuscode()).body(response);
    }
    
    
    
}
