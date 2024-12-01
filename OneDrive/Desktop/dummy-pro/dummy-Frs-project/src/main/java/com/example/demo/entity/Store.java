package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // More portable than GenerationType.AUTO
    @Column(name = "store_id")
    private short storeId;

    @Column(name = "manager_staff_id", nullable = false)
    private short managerStaffId;

    @Column(name = "last_update", nullable = false, insertable = false, updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false, foreignKey = @ForeignKey(name = "fk_store_address"))
    private Address address;

    @OneToMany(mappedBy = "storeId") // Corrected mapping: Uses storeId field in Customer entity
    private List<Customer> customers;

    // ... other fields ...
}

