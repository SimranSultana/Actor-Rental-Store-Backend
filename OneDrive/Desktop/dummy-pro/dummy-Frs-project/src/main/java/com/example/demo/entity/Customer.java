package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "customer_id", nullable = false)
    private short customer_id;

    @ManyToOne
    @JoinColumn(name = "store_id",nullable = false)
    @JsonIgnore
    private Store storeId;
    
    @Column(name = "first_name", nullable = false, length = 45)
    private String first_name;
    
    @Column(name = "last_name", nullable = false, length = 45)
    private String last_name;
    
    @Column(name = "email", length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false, foreignKey = @ForeignKey(name = "fk_customer_address"))
    @JsonIgnore
    private Address address;

    @OneToMany(mappedBy="customer")
    @JsonIgnore
    List<Rental> rental;

    @OneToMany(mappedBy="customer")
    @JsonIgnore
    List<Payment> payment;

    @Column(name = "active", nullable = false)
    private int active;
    
    @Column(name = "create_date", nullable = false)
    private LocalDateTime create_date;
    
    @Column(name = "last_update", insertable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime last_update;
}
