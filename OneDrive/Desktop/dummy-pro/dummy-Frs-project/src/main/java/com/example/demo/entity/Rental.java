package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int rental_id;

    @Column(name = "rental_date", nullable = false)
    private LocalDateTime rental_date;
    
    @Column(name = "return_date")
    private LocalDateTime return_date;
    
    @Column(name = "last_update", nullable = false, updatable = false)
    private LocalDateTime last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @OneToMany(mappedBy="rental")
    List<Payment> payment;

}
