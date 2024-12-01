package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "store_id")
	    private short storeId;

//	    @ManyToMany
//	    @JoinTable(
//	        name = "store_staff",
//	        joinColumns = @JoinColumn(name = "store_id"),
//	        inverseJoinColumns = @JoinColumn(name = "staff_id")
//	    )
//	    private Set<Staff> staff; // Consistent with `Staff` entity

//	    @Column(unique = true)
//	    private Long phoneNumber;
//
//	    @ManyToOne
//	    @JoinColumn(name = "address_id", nullable = false)
//	    @JsonIgnore
//	    private Address address;
//
//	    @OneToMany(mappedBy = "store")
//	    @JsonIgnore
//	    private List<Inventory> inventory;
//
//	    @OneToMany(mappedBy = "store")
//	    @JsonIgnore
//	    private List<Customer> customers;
//
//	    @UpdateTimestamp
//	    @Column(name = "last_update", nullable = false, updatable = false)
//	    private LocalDateTime lastUpdate;


}
